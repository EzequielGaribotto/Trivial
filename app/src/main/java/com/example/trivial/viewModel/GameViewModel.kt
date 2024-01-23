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
    fun modRonda(value:Int) {
        estadoJuego.ronda = value
    }

    fun restarTiempo() {
        configuracion.tiempo--
    }

    fun modTiempo(value:Int) {
        configuracion.tiempo = value
    }
    var darkMode:Boolean by mutableStateOf(false)
        private set
    fun switchTheme() {
        darkMode = !darkMode
    }

    var preguntas: Preguntas by mutableStateOf(Preguntas())
        private set

    var estadoJuego: EstadoJuego by mutableStateOf(EstadoJuego())
        private set

    fun resetScore() {
        estadoJuego.puntuacion = 0
    }

    fun randomQuestionIndex() {
        estadoJuego.questionIndex = (0 until preguntas.enunciados.size).random()
    }

    fun nextRound() {
        estadoJuego.ronda = estadoJuego.ronda+1
    }

    fun getRound():Int {
        return estadoJuego.ronda
    }

    fun getRounds():Int {
        return configuracion.rondas
    }

    fun getQuestionIndex():Int {
        return estadoJuego.questionIndex
    }

    fun getEnunciadoActual():String {
        return preguntas.enunciados[getQuestionIndex()]
    }

    fun getTiempo():Int {
        return configuracion.tiempo
    }
}
