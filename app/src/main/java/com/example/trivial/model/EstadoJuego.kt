package com.example.trivial.model

data class EstadoJuego(
    var intentosConsumidos: Int = 0,
    var score: Int = 0,
    var respuestasPresionadas: Array<Boolean> = arrayOf(false)
)