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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.GameViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val filas = 2
const val columnas = 2

data class PreguntasConsumidas(
    var enunciados: MutableList<String> = mutableListOf(),
    var respuestas: MutableList<Array<String>> = mutableListOf(),
    var colorRespuesta: MutableList<Array<Color>> = mutableListOf(),
    var respuestaCorrecta: MutableList<String> = mutableListOf(),
    var puntos: MutableList<Int> = mutableListOf()
)

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    val preguntasConsumidas = PreguntasConsumidas()
    val preguntas = viewModel.preguntas
    val estado = viewModel.estadoJuego
    val config = viewModel.configuracion
    val tiempoInicial by remember { mutableIntStateOf(config.tiempo) }
    var ronda by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (config.rondas >= ronda) {
            // ROUND COUNTER
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
                        "Ronda: $ronda/${config.rondas}",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 43.sp,
                        letterSpacing = 5.sp
                    )
                }
            }
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
                        preguntas.enunciados[estado.questionIndex],
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 43.sp,
                        letterSpacing = 5.sp
                    )
                }
            }
            // ANSWER 1..4
            Spacer(modifier = Modifier.height(8.dp))
            repeat(filas) { filaIndex ->
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
                                .background(
                                    preguntas.colorRespuesta[estado.questionIndex][answerIndex],
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    if (config.tiempo > 0) {
                                        preguntas.colorRespuesta =
                                            MutableList(preguntas.enunciados.size) { Array(4) { Color.White } }
                                        if (preguntas.respuestas[estado.questionIndex][answerIndex] == preguntas.respuestaCorrecta[estado.questionIndex]) {
                                            estado.puntuacion += preguntas.puntos[estado.questionIndex]
                                            preguntas.colorRespuesta[estado.questionIndex][answerIndex] =
                                                Color.Green
                                        } else {
                                            preguntas.colorRespuesta[estado.questionIndex][answerIndex] =
                                                Color.Red
                                            //preguntas.colorRespuesta[estado.questionIndex].indexOf(preguntas.respuestaCorrecta[estado.questionIndex]) = Color.Green
                                        }

                                        consumirPregunta(preguntas, preguntasConsumidas, estado)
                                        updateQuestionIndex(
                                            preguntas,
                                            preguntasConsumidas,
                                            estado,
                                            viewModel
                                        )
                                    }
                                    viewModel.modTiempo(tiempoInicial)
                                    ronda++
                                }) {
                                Text(
                                    text = preguntas.respuestas[estado.questionIndex][answerIndex],
                                    color = Color.Black,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .background(preguntas.colorRespuesta[estado.questionIndex][answerIndex]),
                                )
                            }
                        }
                    }
                }
            }
        } else {
            navController.navigate(Routes.ResultScreen.route)
        }
        if (ronda != config.rondas + 1) {
            Contador(config, tiempoInicial, viewModel)
        }
    }
}

fun consumirPregunta(
    preguntas: Preguntas,
    preguntasConsumidas: PreguntasConsumidas,
    estado: EstadoJuego
) {
    preguntasConsumidas.enunciados.add(preguntas.enunciados[estado.questionIndex])
    preguntasConsumidas.respuestas.add(preguntas.respuestas[estado.questionIndex])
    preguntasConsumidas.respuestaCorrecta.add(preguntas.respuestaCorrecta[estado.questionIndex])
    preguntasConsumidas.colorRespuesta.add(preguntas.colorRespuesta[estado.questionIndex])
    preguntasConsumidas.puntos.add(preguntas.puntos[estado.questionIndex])
}

fun updateQuestionIndex(
    preguntas: Preguntas,
    preguntasConsumidas: PreguntasConsumidas,
    estado: EstadoJuego,
    viewModel: GameViewModel
) {
    var valid = false
    while (!valid) {
        viewModel.randomQuestionIndex(preguntas.enunciados.size)
        if (preguntas.enunciados[estado.questionIndex] !in preguntasConsumidas.enunciados) {
            valid = true
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Contador(config: Configuracion, tiempoInicial: Int, viewModel: GameViewModel) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        LinearProgressIndicator(
            color = Color.Cyan,
            trackColor = Color.Black,
            progress = config.tiempo.toFloat() / tiempoInicial
        )
        Text(text = "\n${config.tiempo} s")

        DisposableEffect(Unit) {
            val job = coroutineScope.launch {
                repeat(tiempoInicial) {
                    if (config.tiempo > 0) {
                        viewModel.restarTiempo()
                        println("Iteración: $it, Tiempo: ${config.tiempo}")
                        delay(1000)
                    }
                }
            }

            onDispose {
                // Cancelar la coroutine al eliminar el efecto
                job.cancel()
            }
        }
    }
}
