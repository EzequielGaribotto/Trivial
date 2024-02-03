package com.example.trivial.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.viewModel.GameViewModel
import kotlinx.coroutines.delay

const val filas = 2
const val columnas = 2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, vm: GameViewModel) {
    var timeLeft by rememberSaveable { mutableIntStateOf(vm.getSliderTime()) }
    val animatedProgress by animateFloatAsState(targetValue = timeLeft.toFloat() / vm.getSliderTime(),
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing,
        ), label = ""
    )
    var stopTimer by rememberSaveable { mutableStateOf( false )}
    val configuration = LocalConfiguration.current
    if (!vm.playing) {
        navController.navigate("ResultScreen")
    } else {
        LaunchedEffect(timeLeft, stopTimer) {
            while (timeLeft > 0 && !stopTimer) {
                delay(10L)
                timeLeft--
            }
            if (timeLeft == 0) {
                vm.preguntaFallada()
            }
            vm.disableButton()
            vm.showBackgroundColor()
            delay(vm.getDelayMillis().toLong())
            vm.enableButton()
            vm.hideBackgroundColor()
            vm.nextQuestion()
            timeLeft = vm.getSliderTime()
            stopTimer = false
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Ronda ${vm.getRonda()}/${vm.getRondas()}",
                color = if (vm.isDarkMode()) Color.White else Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp
            )
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = vm.getEnunciadoActual(),
                        color = if (vm.isDarkMode()) Color.White else Color.Black,
                        textAlign = TextAlign.Center,
                        letterSpacing = 2.sp
                    )
                }
            }
            if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                Image(
                    painter = painterResource(id = vm.getQuestionImage()),
                    contentDescription = "Image",
                    Modifier.fillMaxSize(0.6f)
                        .padding(8.dp)
                )
                repeat(filas) { filaIndex ->
                    Row(
                        modifier = Modifier.fillMaxWidth(0.95f)
                    ) {
                        repeat(columnas) { colIndex ->
                            val answerIndex = filaIndex * columnas + colIndex
                            Button(
                                onClick = {
                                    vm.updateScore(answerIndex)
                                    stopTimer = true
                                }, modifier = Modifier
                                    .padding(8.dp)
                                    .weight(1f)
                                    .border(
                                        width = 5.dp,
                                        color = if (!vm.isDarkMode()) Color.Black else Color.White,
                                        shape = RoundedCornerShape(8.dp),
                                    )
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        color = vm.getBackgroundColor(answerIndex)
                                    ), colors = ButtonDefaults.buttonColors(
                                    containerColor = vm.getBackgroundColor(answerIndex)
                                ), shape = RoundedCornerShape(8.dp), enabled = vm.isButtonEnabled()
                            ) {
                                Text(
                                    text = vm.getAnswer(answerIndex),
                                    textAlign = TextAlign.Center,
                                    color = if (vm.isButtonEnabled() && vm.isDarkMode()) Color.White else Color.Black,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                    if (filaIndex == filas - 1) {
                        Spacer(modifier = Modifier.height(16.dp))
                        LinearProgressIndicator(
                            progress = animatedProgress,
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(15.dp)
                        )
                        Text(text = "$timeLeft s", color = if (!vm.isDarkMode()) Color.Black else Color.White)
                    }
                }
            } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(0.95f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            painter = painterResource(id = vm.getQuestionImage()),
                            contentDescription = "Image",
                            Modifier.fillMaxSize(0.25f)
                        )
                        Column(
                            Modifier.fillMaxWidth(0.95f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            repeat(filas) {filaIndex ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(0.95f)
                                ) {
                                    repeat(columnas) {colIndex ->
                                        val answerIndex = filaIndex * columnas + colIndex
                                        Button(
                                            onClick = {
                                                vm.updateScore(answerIndex)
                                                stopTimer = true
                                            },
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .weight(1f)
                                                .border(
                                                    width = 5.dp,
                                                    color = if (!vm.isDarkMode()) Color.Black else Color.White,
                                                    shape = RoundedCornerShape(8.dp),
                                                )
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(
                                                    color = vm.getBackgroundColor(answerIndex)
                                                ), colors = ButtonDefaults.buttonColors(
                                                containerColor = vm.getBackgroundColor(answerIndex)
                                            ), shape = RoundedCornerShape(8.dp), enabled = vm.isButtonEnabled()
                                        ) {
                                            Text(
                                                text = vm.getAnswer(answerIndex),
                                                textAlign = TextAlign.Center,
                                                color = if (vm.isButtonEnabled() && vm.isDarkMode()) Color.White else Color.Black,
                                                modifier = Modifier.align(Alignment.CenterVertically)
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            LinearProgressIndicator(
                                progress = animatedProgress,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(15.dp)
                            )
                            Text(text = "$timeLeft s", color = if (!vm.isDarkMode()) Color.Black else Color.White)
                        }
                    }
            }
        }
    }
}
