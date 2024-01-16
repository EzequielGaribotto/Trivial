package com.example.trivial.model

data class Configuracion(
    var dificultad: String = "Normal",
    var rondas: Int = 5,
    var tiempo: Int = 60,
    var theme: Boolean = false,
)