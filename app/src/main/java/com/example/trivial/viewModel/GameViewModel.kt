package com.example.trivial.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
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
    @Synchronized
    fun restarTiempo() {
        configuracion.tiempo--
    }
    @Synchronized
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

    fun getUserAnswer(answerIndex:Int):String {
        return preguntas.respuestas[getQuestionIndex()][answerIndex]
    }
    fun resetBackgroundAnswersColor() {
        preguntas.colorRespuesta = MutableList(preguntas.enunciados.size) { Array(4) { Color.White } }
    }
    fun getCorrectAnswer():String {
        return preguntas.respuestaCorrecta[getQuestionIndex()]
    }
    fun updateScore(){
        estadoJuego.puntuacion += preguntas.puntos[getQuestionIndex()]
    }
    fun updateAnswerBackgroundColor(answerIndex:Int, color:Color) {
        preguntas.colorRespuesta[getQuestionIndex()][answerIndex] = color
    }

    fun getAnswerBackgroundColor(answerIndex: Int):Color {
        return preguntas.colorRespuesta[getQuestionIndex()][answerIndex]
    }
    fun getAnswer(answerIndex: Int):String {
        return preguntas.respuestas[getQuestionIndex()][answerIndex]
    }
    fun getArrayAnswersSize():Int {
        return preguntas.respuestas.size
    }
    fun getEnunciadoActual():String {
        return preguntas.enunciados[getQuestionIndex()]
    }
    @Synchronized
    fun getTiempo():Int {
        return configuracion.tiempo
    }
}
