package com.example.trivial.model

data class EstadoJuego(
    var intentosConsumidos: Int = 0,
    var puntuacion: Int = 0,
    var questionIndex: Int = 0,
)