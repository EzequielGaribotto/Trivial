package com.example.trivial.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.GameViewModel

const val filas = 2
const val columnas = 2

data class PreguntasConsumidas (
    var enunciados:MutableList<String> = mutableListOf(),
    var respuestas:MutableList<Array<String>> = mutableListOf(),
    var colorRespuesta: MutableList<Array<Color>> = mutableListOf(),
    var respuestaCorrecta:MutableList<String> = mutableListOf(),
    var puntos:MutableList<Int> = mutableListOf()
)
@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    val preguntasConsumidas = PreguntasConsumidas()
    val preguntas = viewModel.preguntas
    val estado = viewModel.estadoJuego
    val config = viewModel.configuracion
    var ronda by remember { mutableIntStateOf(0) }
    var questionIndex by remember { mutableIntStateOf((0 until preguntas.enunciados.size).random()) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // QUESTION STATEMENT
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    preguntas.enunciados[questionIndex],
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 43.sp,
                    letterSpacing = 5.sp
                )
            }
        }

        // ANSWER 1..4
        Spacer(modifier = Modifier.height(8.dp))
        if (config.rondas >= ronda) repeat(filas) { filaIndex ->
            Row(modifier = Modifier.padding(5.dp)) {
                repeat(columnas) { colIndex ->
                    val answerIndex = filaIndex * columnas + colIndex
                    if (answerIndex < preguntas.respuestas.size) {
                        BoxWithConstraints(modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .padding(5.dp)
                            .border(
                                width = 5.dp,
                                color = if (!viewModel.darkMode) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(preguntas.colorRespuesta[questionIndex][answerIndex], shape = RoundedCornerShape(8.dp))
                            .clickable {
                                preguntas.colorRespuesta = MutableList(preguntas.enunciados.size) { Array(4) {Color.White} }
                                if (preguntas.respuestas[questionIndex][answerIndex] == preguntas.respuestaCorrecta[questionIndex]) {
                                    estado.puntuacion += preguntas.puntos[questionIndex]
                                    preguntas.colorRespuesta[questionIndex][answerIndex] = Color.Green
                                } else {
                                    preguntas.colorRespuesta[questionIndex][answerIndex] = Color.Red
                                    //preguntas.colorRespuesta[questionIndex].indexOf(preguntas.respuestaCorrecta[questionIndex]) = Color.Green
                                }

                                preguntasConsumidas.enunciados.add(preguntas.enunciados[questionIndex])
                                preguntasConsumidas.respuestas.add(preguntas.respuestas[questionIndex])
                                preguntasConsumidas.respuestaCorrecta.add(preguntas.respuestaCorrecta[questionIndex])
                                preguntasConsumidas.colorRespuesta.add(preguntas.colorRespuesta[questionIndex])
                                preguntasConsumidas.puntos.add(preguntas.puntos[questionIndex])

                                var valid = false
                                while (!valid) {
                                    questionIndex = (0 until preguntas.enunciados.size).random()
                                    if (preguntas.enunciados[questionIndex] !in preguntasConsumidas.enunciados) {
                                        valid = true
                                    }
                                }
                                ronda++
                            }) {
                            Text(
                                text = preguntas.respuestas[questionIndex][answerIndex],
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .background(preguntas.colorRespuesta[questionIndex][answerIndex]),
                            )
                        }
                    }
                }
            }
        } else {
            navController.navigate(Routes.ResultScreen.route)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(color = Color.Cyan, trackColor = Color.Black, progress = ronda.toFloat()/config.rondas)
    }
}

