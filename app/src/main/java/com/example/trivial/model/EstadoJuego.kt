package com.example.trivial.model

val preguntas:Preguntas = Preguntas()
class EstadoJuego(
    var score: Int = 0,
    var questionIndex: Int = (0 until preguntas.enunciados.size).random(),
    var ronda:Int = 1
)