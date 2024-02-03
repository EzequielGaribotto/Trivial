package com.example.trivial.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Configuracion(
    var dificultad: String = "Normal",
    var rondas: Int = 5,
    var sliderTime:Int = 20,
    var delayMillis:Int = 1500,
    var darkMode: MutableState<Boolean> = mutableStateOf(false),
    var geografia: MutableState<Boolean> = mutableStateOf(true),
    var deportes: MutableState<Boolean> = mutableStateOf(true),
    var historia: MutableState<Boolean> = mutableStateOf(true),
    var matematicas: MutableState<Boolean> = mutableStateOf(true),
    var quimica: MutableState<Boolean> = mutableStateOf(true),
    var videojuegos: MutableState<Boolean> = mutableStateOf(true),
    var notAllowedList: MutableList<Int> = mutableListOf(),


    // Testing settings
//    var dificultad: String = "Fácil",
//    var rondas: Int = 15,
//    var sliderTime:Int = 1,
//    var delayMillis:Int = 100,
//    var darkMode: MutableState<Boolean> = mutableStateOf(true),
//    var geografia: MutableState<Boolean> = mutableStateOf(true),
//    var deportes: MutableState<Boolean> = mutableStateOf(true),
//    var historia: MutableState<Boolean> = mutableStateOf(true),
//    var matematicas: MutableState<Boolean> = mutableStateOf(true),
//    var quimica: MutableState<Boolean> = mutableStateOf(true),
//    var videojuegos: MutableState<Boolean> = mutableStateOf(true),
//    var notAllowedList: MutableList<Int> = mutableListOf(),
)

