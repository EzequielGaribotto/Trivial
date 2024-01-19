package com.example.trivial.model

val preguntas:Preguntas = Preguntas()
data class EstadoJuego(
    var intentosConsumidos: Int = 0,
    var puntuacion: Int = 0,
    var questionIndex: Int = (0 until preguntas.enunciados.size).random(),
)