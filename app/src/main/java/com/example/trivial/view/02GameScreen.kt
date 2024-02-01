package com.example.trivial.view

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.R
import com.example.trivial.viewModel.GameViewModel

const val filas = 2
const val columnas = 2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, vm: GameViewModel, windowSize: WindowSizeClass) {
    val handler = Handler(Looper.getMainLooper())
    var arrayRespuestasIndices = mutableListOf<Int>()
    if (!vm.playing) {
        navController.navigate("ResultScreen")
        vm.cancelTimer()
    } else {
        LaunchedEffect(vm.getRonda()) {
            vm.startTimer()
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ronda ${vm.getRonda()}/${vm.getRondas()}",
                color = if (vm.darkMode) Color.White else Color.Black,
                fontSize = 45.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp
            )
            Text(
                text = vm.getEnunciadoActual(),
                fontSize = 43.sp,
                color = if (vm.darkMode) Color.White else Color.Black,
                textAlign = TextAlign.Center,
                letterSpacing = 5.sp
            )
            if (windowSize.widthSizeClass <= WindowWidthSizeClass.Medium) {
                Image(
                    painter = painterResource(id = vm.getQuestionImage()),
                    contentDescription = "Image"
                )
                repeat(filas) { filaIndex ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                    ) {
                        repeat(columnas) { colIndex ->
                            var answerIndex by remember { mutableIntStateOf((0 until filas * columnas).random()) }
                            var randomized = false
                            while (!randomized) {
                                if (answerIndex !in arrayRespuestasIndices) {
                                    arrayRespuestasIndices.add(answerIndex)
                                    randomized = true
                                } else {
                                    answerIndex = (0 until filas * columnas).random()
                                }
                            }
                            Button(
                                onClick = {
                                    vm.updateScore(answerIndex)
                                    vm.disableButton()
                                    vm.showBackgroundColor()
                                    vm.cancelTimer()
                                    handler.postDelayed({
                                        vm.enableButton()
                                        vm.hideBackgroundColor()
                                        vm.nextQuestion()
                                        arrayRespuestasIndices.clear()
                                        answerIndex = (0 until filas * columnas).random()
                                    }, vm.getDelayMillis().toLong())
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .border(
                                        width = 5.dp,
                                        color = if (!vm.darkMode) Color.Black else Color.White,
                                        shape = RoundedCornerShape(8.dp),
                                    )
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        color = vm.getBackgroundColor(answerIndex)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = vm.getBackgroundColor(answerIndex)
                                ),
                                shape = RoundedCornerShape(8.dp),
                                enabled = vm.buttonEnabled
                            ) {
                                Text(
                                    text = vm.getAnswer(answerIndex),
                                    color = if (!vm.darkMode) Color.Black else Color.White,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .background(
                                            color = vm.getBackgroundColor(answerIndex)
                                        ),
                                )
                            }
                            if (colIndex < columnas - 1) {
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            } else {
                Image(
                    painter = painterResource(id = vm.getQuestionImage()),
                    contentDescription = "Image"
                )
                repeat(filas) { answerIndex ->
                    Row(modifier = Modifier.padding(5.dp)) {
                        if (answerIndex < vm.getArrayAnswersSize()) {
                            Button(
                                onClick = {
                                    vm.updateScore(answerIndex)
                                    vm.disableButton()
                                    vm.showBackgroundColor()
                                    vm.cancelTimer()
                                    handler.postDelayed({
                                        vm.enableButton()
                                        vm.hideBackgroundColor()
                                        vm.nextQuestion()
                                    }, vm.getDelayMillis().toLong())
                                },
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                                    .padding(5.dp)
                                    .border(
                                        width = 5.dp,
                                        color = if (!vm.darkMode) Color.Black else Color.White,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(
                                        color = vm.getBackgroundColor(answerIndex)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = vm.getBackgroundColor(answerIndex)
                                ),
                                shape = RoundedCornerShape(8.dp),
                                enabled = vm.buttonEnabled
                            ) {
                                Text(
                                    text = vm.getAnswer(answerIndex),
                                    color = if (!vm.darkMode) Color.Black else Color.White,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .background(
                                            color = vm.getBackgroundColor(answerIndex)
                                        ),
                                )
                            }
                        }
                    }
                }
            }
            LinearProgressIndicator(
                color = Color.Cyan,
                trackColor = if (vm.darkMode) Color.White else Color.Black,
                progress = vm.timerProgress,
            )
            Text(text = "\n${vm.getTiempo()} s")
        }
    }
}