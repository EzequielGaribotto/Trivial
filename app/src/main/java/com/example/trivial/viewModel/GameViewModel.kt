package com.example.trivial.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas

class GameViewModel: ViewModel() {
    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set
    fun modDificultad(value:String) {
        configuracion.dificultad = value
    }
    fun modRondas(value:Int) {
        configuracion.rondas = value
    }
    fun modTiempo(value:Int) {
        configuracion.tiempo = value
    }
    fun modTheme(value:Boolean) {
        configuracion.modoOscuro = value
    }


    var preguntas: Preguntas by mutableStateOf(Preguntas())
        private set

    var estadoJuego: EstadoJuego by mutableStateOf(EstadoJuego())
        private set
    fun modIntentos(value:Int) {
        estadoJuego.intentosConsumidos = value
    }
    fun modScore(value:Int) {
        estadoJuego.puntuacion = value
    }
}
