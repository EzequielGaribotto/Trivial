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
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.GameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    val preguntas = viewModel.preguntas
    val estado = viewModel.estadoJuego
    val config = viewModel.configuracion
    val tiempoInicial by remember { mutableIntStateOf(viewModel.configuracion.tiempo) }
    val preguntasConsumidasList:MutableList<PreguntasConsumidas> = mutableListOf()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (config.rondas >= estado.ronda) {
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
                        "Ronda: ${estado.ronda}/${config.rondas}",
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

                                        consumirPregunta(viewModel, preguntasConsumidasList)
                                        updateQuestionIndex(
                                            preguntas,
                                            preguntasConsumidasList,
                                            estado,
                                            viewModel
                                        )
                                    }
                                    viewModel.modTiempo(tiempoInicial)
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
        if (estado.ronda != config.rondas + 1) {
            Contador(tiempoInicial, viewModel)
        }
    }
}

fun updateQuestionIndex(
    preguntas: Preguntas,
    preguntasConsumidasList: MutableList<PreguntasConsumidas>,
    estado: EstadoJuego,
    viewModel: GameViewModel
) {
    var valid = false
    while (!valid) {
        viewModel.randomQuestionIndex(preguntas.enunciados.size)
        val enunciadoActual = preguntas.enunciados[estado.questionIndex]
        val enunciadosConsumidos:MutableList<String> = mutableListOf()
        for (pregunta in preguntasConsumidasList.indices) {
            enunciadosConsumidos.add(preguntasConsumidasList[pregunta].enunciados[pregunta])
        }
        if (enunciadoActual !in enunciadosConsumidos) {
            valid = true
        }
    }
}


fun consumirPregunta(
    viewModel:GameViewModel,
    preguntasConsumidasList: MutableList<PreguntasConsumidas>
) {
    val preguntaConsumida = PreguntasConsumidas()
    preguntaConsumida.enunciados.add(viewModel.preguntas.enunciados[viewModel.estadoJuego.questionIndex])
    preguntaConsumida.respuestas.add(viewModel.preguntas.respuestas[viewModel.estadoJuego.questionIndex])
    preguntaConsumida.respuestaCorrecta.add(viewModel.preguntas.respuestaCorrecta[viewModel.estadoJuego.questionIndex])
    preguntaConsumida.colorRespuesta.add(viewModel.preguntas.colorRespuesta[viewModel.estadoJuego.questionIndex])
    preguntaConsumida.puntos.add(viewModel.preguntas.puntos[viewModel.estadoJuego.questionIndex])
    preguntasConsumidasList.add(preguntaConsumida)
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Contador(tiempoInicial: Int, viewModel: GameViewModel) {
    val coroutineScope = rememberCoroutineScope()
    var tiempoRestante by remember { mutableIntStateOf(tiempoInicial) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        LinearProgressIndicator(
            color = Color.Cyan,
            trackColor = Color.Black,
            progress = tiempoRestante.toFloat() / tiempoInicial
        )
        Text(text = "\n${tiempoRestante} s")

        DisposableEffect(Unit) {
            val job = coroutineScope.launch {
                while (viewModel.estadoJuego.ronda <= viewModel.configuracion.rondas) {
                    repeat(tiempoInicial) {
                        if (tiempoRestante > 0) {
                            viewModel.restarTiempo()
                            tiempoRestante--
                            println("Iteración: $it, Tiempo: $tiempoRestante")
                            delay(1000)
                        }
                    }
                    viewModel.nextRound()
                    if (viewModel.estadoJuego.ronda <= viewModel.configuracion.rondas) {
                        viewModel.modTiempo(tiempoInicial)
                        tiempoRestante = tiempoInicial
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

