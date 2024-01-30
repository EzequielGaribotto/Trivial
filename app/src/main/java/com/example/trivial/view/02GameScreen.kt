package com.example.trivial.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.viewModel.GameViewModel

const val filas = 2
const val columnas = 2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, vm: GameViewModel, windowSize: WindowSizeClass) {
    if (vm.gameFinished) {
        navController.navigate("ResultScreen")
        vm.cancelTimer()
    } else {
        LaunchedEffect(vm.getRonda()) {
            vm.startTimer()
        }
        vm.startGame()
        // ROUND COUNTER
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
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
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    fontSize = 43.sp,
                    color = if (vm.darkMode) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    letterSpacing = 5.sp
                )

            }
            // ANSWER 1..4
            Spacer(modifier = Modifier.height(8.dp))
            if (windowSize.widthSizeClass <= WindowWidthSizeClass.Medium) {
                repeat(filas) { filaIndex ->
                    Row(modifier = Modifier.padding(5.dp)) {
                        repeat(columnas) { colIndex ->
                            val answerIndex = filaIndex * columnas + colIndex
                            if (answerIndex < vm.getArrayAnswersSize()) {
                                BoxWithConstraints(modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth(0.25f)
                                    .padding(5.dp)
                                    .border(
                                        width = 5.dp,
                                        color = if (!vm.darkMode) Color.Black else Color.LightGray,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(
                                        color = vm.getAnswerBackgroundColor(answerIndex),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable {
                                        if (vm.respuestaCorrecta(answerIndex)) {
                                            vm.updateScore()
                                            vm.updateAnswerBackgroundColor(answerIndex, Color.Green)
                                        } else {
                                            vm.updateAnswerBackgroundColor(answerIndex, Color.Red)
                                            //preguntas.colorRespuesta[vm.getQuestionIndex()].indexOf(preguntas.respuestaCorrecta[estado.questionIndex]) = Color.Green
                                        }
                                        vm.nextQuestion()
                                    }) {
                                    Text(
                                        text = vm.getAnswer(answerIndex),
                                        color = Color.Black,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .background(
                                                color = vm.getAnswerBackgroundColor(
                                                    answerIndex
                                                )
                                            ),
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                repeat(filas) { filaIndex ->
                    Row(modifier = Modifier.padding(5.dp)) {
                        repeat(columnas) { colIndex ->
                            val answerIndex = filaIndex * columnas + colIndex
                            if (answerIndex < vm.getArrayAnswersSize()) {
                                BoxWithConstraints(modifier = Modifier
                                    .padding(5.dp)
                                    .border(
                                        width = 5.dp,
                                        color = if (!vm.darkMode) Color.Black else Color.LightGray,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(
                                        color = vm.getAnswerBackgroundColor(answerIndex),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable {
                                        if (vm.respuestaCorrecta(answerIndex)) {
                                            vm.updateScore()
                                            vm.updateAnswerBackgroundColor(answerIndex, Color.Green)
                                        } else {
                                            vm.updateAnswerBackgroundColor(answerIndex, Color.Red)
                                        }
                                        vm.nextQuestion()
                                    }) {

                                    Text(
                                        text = vm.getAnswer(answerIndex),
                                        color = Color.Black,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .background(
                                                color = vm.getAnswerBackgroundColor(answerIndex)
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
                trackColor = Color.Black,
                progress = vm.timerProgress,
            )
            Text(text = "\n${vm.getTiempo()} s")
        }
    }
}