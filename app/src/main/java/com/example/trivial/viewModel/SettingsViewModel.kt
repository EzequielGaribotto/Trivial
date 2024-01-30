package com.example.trivial.viewModel

import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import com.example.trivial.model.*
class SettingsViewModel: ViewModel() {

    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set
    var estadoJuego: EstadoJuego by mutableStateOf(EstadoJuego())
        private set


    fun setDificultad(value:String) {
        configuracion.dificultad = value
    }

    fun getDificultad():String {
        return configuracion.dificultad
    }

    fun setRondas(value:Int) {
        configuracion.rondas = value
    }
    fun getRondas():Int {
        return configuracion.rondas
    }

    fun setRonda(value:Int) {
        estadoJuego.ronda = value
    }

    fun getRonda():Int {
        return estadoJuego.ronda
    }


    fun setSliderTiempo(value:Int) {
        configuracion.sliderTime = value
    }

    fun getSliderTiempo():Int {
        return configuracion.sliderTime
    }


    var darkMode:Boolean by mutableStateOf(false)
        private set

    fun isDarkMode():Boolean {
        return darkMode
    }
    fun switchTheme() {
        darkMode = !darkMode
    }
}
