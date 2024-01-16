package com.example.trivial.model

data class Configuracion(
    var dificultad: String = "Normal",
    var rondas: Int = 5,
    var tiempo: Int = 40,
    var modoOscuro: Boolean = false,
)