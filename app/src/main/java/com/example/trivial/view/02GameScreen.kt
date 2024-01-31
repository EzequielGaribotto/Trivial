package com.example.trivial.view

import android.annotation.SuppressLint
import android.media.Image
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    if (!vm.playing) {
        navController.navigate("ResultScreen")
        vm.cancelTimer()
    } else {
        LaunchedEffect(vm.getRonda()) {
            vm.startTimer()
        }
        // ROUND COUNTER
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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
                    modifier = Modifier.fillMaxHeight(0.6f),
                    fontSize = 43.sp,
                    color = if (vm.darkMode) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    letterSpacing = 5.sp
                )
                Column(
                    Modifier.padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier.paint(
                            painterResource(id = R.drawable.logo),
                            contentScale = ContentScale.FillBounds
                        )
                    )
                }

            }
            // ANSWER 1..4
            Column (
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .fillMaxWidth(1.0f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(8.dp))
                if (windowSize.widthSizeClass <= WindowWidthSizeClass.Medium) {
                    repeat(filas) { filaIndex ->
                        Row(modifier = Modifier.padding(5.dp)) {
                            repeat(columnas) { colIndex ->
                                val answerIndex = filaIndex * columnas + colIndex
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
                } else {
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