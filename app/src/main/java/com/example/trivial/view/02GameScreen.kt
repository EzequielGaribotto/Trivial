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
import androidx.compose.foundation.layout.width
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
import com.example.trivial.viewModel.*

const val filas = 2
const val columnas = 2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, gm: GameViewModel, windowSize: WindowSizeClass) {
    if (gm.gameFinished) {
        gm.cancelTimer()
        navController.navigate("ResultScreen")
    } else {
        LaunchedEffect(gm.getRonda()) {
            gm.startTimer()
        }
        gm.startGame()
        // ROUND COUNTER
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Ronda ${gm.getRonda()}/${gm.getRondas()}",
                    color = if (gm.isDarkMode()) Color.White else Color.Black,
                    fontSize = 45.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 5.sp
                )
                Text(
                    text = gm.getEnunciadoActual(),
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    fontSize = 43.sp,
                    color = if (gm.isDarkMode()) Color.White else Color.Black,
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
                            if (answerIndex < gm.getArrayAnswersSize()) {
                                BoxWithConstraints(modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .padding(5.dp)
                                    .border(
                                        width = 5.dp,
                                        color = if (!gm.isDarkMode()) Color.Black else Color.LightGray,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(
                                        color = gm.getAnswerBackgroundColor(answerIndex),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable {
                                        if (gm.respuestaCorrecta(answerIndex)) {
                                            gm.updateScore()
                                            gm.updateAnswerBackgroundColor(answerIndex, Color.Green)
                                        } else {
                                            gm.updateAnswerBackgroundColor(answerIndex, Color.Red)
                                            //preguntas.colorRespuesta[gm.getQuestionIndex()].indexOf(preguntas.respuestaCorrecta[estado.questionIndex]) = Color.Green
                                        }
                                        gm.nextQuestion()
                                    }) {
                                    Text(
                                        text = gm.getAnswer(answerIndex),
                                        color = Color.Black,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .background(
                                                color = gm.getAnswerBackgroundColor(
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

            }
            LinearProgressIndicator(
                color = Color.Cyan,
                trackColor = Color.Black,
                progress = gm.timerProgress,
            )
            Text(text = "\n${gm.getTiempo()} s")
        }
    }
}