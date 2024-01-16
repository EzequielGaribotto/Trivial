package com.example.trivial.model

import androidx.compose.ui.graphics.Color

data class Preguntas (
    var pregunta:MutableList<String> = mutableListOf(
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
    var colorRespuesta: MutableList<Color> = MutableList<Color>(pregunta.size) { Color.White },
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

