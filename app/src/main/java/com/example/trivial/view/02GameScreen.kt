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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.GameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val filas = 2
const val columnas = 2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, vm: GameViewModel) {
    val preguntas = vm.preguntas
    val estado = vm.estadoJuego
    val config = vm.configuracion
    val tiempoInicial by remember { mutableIntStateOf(vm.getTiempo()) }
    val enunciadosUsados by remember { mutableStateOf(mutableListOf<String>())}
    var ronda by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (vm.getRounds() >= vm.getRound()) {
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
                        "Ronda: ${ronda}/${vm.getRounds()}",
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
                        vm.getEnunciadoActual(),
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
                                    color = if (!vm.darkMode) Color.Black else Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .background(
                                    color = preguntas.colorRespuesta[vm.getQuestionIndex()][answerIndex],
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    if (config.tiempo > 0) {
                                        preguntas.colorRespuesta = MutableList(preguntas.enunciados.size) { Array(4) { Color.White } }
                                        if (preguntas.respuestas[vm.getQuestionIndex()][answerIndex] == preguntas.respuestaCorrecta[estado.questionIndex]) {
                                            estado.puntuacion += preguntas.puntos[vm.getQuestionIndex()]
                                            preguntas.colorRespuesta[vm.getQuestionIndex()][answerIndex] = Color.Green
                                        } else {
                                            preguntas.colorRespuesta[vm.getQuestionIndex()][answerIndex] = Color.Red
                                            //preguntas.colorRespuesta[vm.getQuestionIndex()].indexOf(preguntas.respuestaCorrecta[estado.questionIndex]) = Color.Green
                                        }
                                        enunciadosUsados.add(vm.getEnunciadoActual())
                                        updateQuestionIndex(enunciadosUsados, vm)
                                    }
                                    ronda++
                                    vm.modRonda(ronda)
                                    vm.modTiempo(tiempoInicial)
                                }) {
                                Text(
                                    text = preguntas.respuestas[vm.getQuestionIndex()][answerIndex],
                                    color = Color.Black,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .background(color = preguntas.colorRespuesta[vm.getQuestionIndex()][answerIndex]),
                                )
                            }
                        }
                    }
                }
            }
        } else {
            navController.navigate(Routes.ResultScreen.route)
        }
        if (ronda != vm.getRounds() + 1) {
            Contador(tiempoInicial, vm, enunciadosUsados)
            ronda = vm.getRound()
        }
    }
}

fun updateQuestionIndex(
    enunciadosUsados: MutableList<String>,
    vm: GameViewModel
) {
    var valid = false
    while (!valid) {
        vm.randomQuestionIndex()
        if (vm.getEnunciadoActual() !in enunciadosUsados) {
            valid = true
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Contador(tiempoInicial: Int, vm: GameViewModel,enunciadosUsados: MutableList<String>) {
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
                while (vm.getRound() <= vm.getRounds()) {
                    repeat(tiempoInicial) {
                        if (tiempoRestante > 0) {
                            vm.restarTiempo()
                            tiempoRestante--
                            println("Iteración: $it, Tiempo: $tiempoRestante")
                            delay(1000)
                        }
                    }
                    vm.nextRound()
                    if (vm.getRound() <= vm.getRounds()) {
                        enunciadosUsados.add(vm.getEnunciadoActual())
                        updateQuestionIndex(enunciadosUsados, vm)
                        vm.modTiempo(tiempoInicial)
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

