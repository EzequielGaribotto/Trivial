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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
    val tiempoInicial by remember { mutableIntStateOf(vm.getTiempo()) }
    val enunciadosUsados by remember { mutableStateOf(mutableListOf<String>())}
    var ronda by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (vm.getRounds() >= ronda) {
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
                        if (answerIndex < vm.getArrayAnswersSize()) {
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
                                    color = vm.getAnswerBackgroundColor(answerIndex),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    if (vm.getTiempo() > 0) {
                                        if (vm.getUserAnswer(answerIndex) == vm.getCorrectAnswer()) {
                                            vm.updateScore()
                                            vm.updateAnswerBackgroundColor(answerIndex,Color.Green)
                                        } else {
                                            vm.updateAnswerBackgroundColor(answerIndex,Color.Red)
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
                                    text = vm.getAnswer(answerIndex),
                                    color = Color.Black,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .background(color = vm.getAnswerBackgroundColor(answerIndex)),
                                )
                            }
                        }
                    }
                }
            }
            if (ronda != vm.getRounds()+1) {
                Contador(tiempoInicial, vm, enunciadosUsados)
                println("HOLA1\n$ronda")
            }
        } else {
            navController.navigate(Routes.ResultScreen.route)
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

@Composable
fun Contador(tiempoInicial: Int, vm: GameViewModel,enunciadosUsados: MutableList<String>) {
    var tiempoRestante by remember { mutableIntStateOf(vm.getTiempo()) }
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
        Text(text = "\n${vm.getTiempo()} s")
        LaunchedEffect(true) {
            repeat(tiempoInicial) {
                if (tiempoRestante > 0) {
                    vm.restarTiempo()
                    tiempoRestante--
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
}

@Composable
fun contador(vm: GameViewModel,enunciadosUsados: MutableList<String>) {
    var time by remember { mutableStateOf(vm.getTiempo()) }

    Column (Modifier.padding(20.dp)){
        var progressStatus by rememberSaveable() { mutableStateOf(1f) }
        LinearProgressIndicator(
            progress = progressStatus,
            color = Color.Magenta)
        var resta by remember { mutableStateOf(1f/time) }
        Row() {
            LaunchedEffect(true) {
                while (vm.getRound() <= vm.getRounds()) {
                    for (i in time - 1 downTo 0) {
                        vm.modTiempo(i)
                        progressStatus -= resta
                        delay(1000)
                        if (i == 0) {
                            progressStatus = 1f
                            vm.modTiempo(time)
                            vm.nextRound()
                            println("NEXTROUND LANUCHEDEFFECT \n${vm.getRound()}")
                            enunciadosUsados.add(vm.getEnunciadoActual())
                            updateQuestionIndex(enunciadosUsados, vm)
                        }
                    }
                }
            }
            Text(text = "${vm.getTiempo()}")
        }
    }
}