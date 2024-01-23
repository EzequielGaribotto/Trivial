package com.example.trivial.model

import androidx.compose.ui.graphics.Color
enum class Preguntas2(val enunciado: String, val respuestas: Array<String>, val colorRespuestas: Array<Color>, val puntos: Int) {
    PREGUNTA1("1 + 1", arrayOf("2", "3", "4", "8"), Array(4) { Color.White }, 1),
    PREGUNTA2("2 + 2", arrayOf("4", "5", "6", "8"), Array(4) { Color.White }, 2),
    PREGUNTA3("3 + 3", arrayOf("6", "7", "8", "9"), Array(4) { Color.White }, 3),
    PREGUNTA4("4 + 4", arrayOf("8", "9", "10", "11"), Array(4) { Color.White }, 4),
    PREGUNTA5("5 + 5", arrayOf("10", "11", "12", "13"), Array(4) { Color.White }, 5),
    PREGUNTA6("6 + 6", arrayOf("12", "13", "14", "15"), Array(4) { Color.White }, 6)
}
class Preguntas (
    var enunciados:MutableList<String> = mutableListOf(
        "1 + 1",
        "2 + 2",
        "3 + 3",
        "4 + 4",
        "5 + 5",
        "6 + 6",
    ),

    var respuestas:MutableList<Array<String>> = mutableListOf(
        arrayOf("2","3","4","8"),
        arrayOf("2","3","4","8"),
        arrayOf("6","3","4","8"),
        arrayOf("2","10","4","8"),
        arrayOf("10","3","4","8"),
        arrayOf("2","3","12","8"),
    ),
    var colorRespuesta: MutableList<Array<Color>> = MutableList(enunciados.size) { Array(respuestas[0].size) {Color.White} },
    var respuestaCorrecta:MutableList<String> = mutableListOf(
        "2",
        "4",
        "6",
        "8",
        "10",
        "12",
    ),
    var puntos:MutableList<Int> = mutableListOf(
        1,
        2,
        3,
        4,
        5,
        6
    )
)

