package com.example.trivial.viewModel
import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas

class GameViewModel: ViewModel() {

    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set

    var sliderTiempo:Int by mutableIntStateOf(configuracion.tiempo)
    var tiempoInicial: Int by mutableIntStateOf(configuracion.tiempo)
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

    fun modSliderTiempo(value:Int) {
        sliderTiempo = value
        modTiempo(value)
    }

    fun getSliderTiempo():Int {
        return sliderTiempo
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
    var gameFinished: Boolean by mutableStateOf(false)
        private set

    fun randomQuestionIndex() {
        estadoJuego.questionIndex = (0 until preguntas.enunciados.size).random()
    }

    fun nextRound() {
        if (estadoJuego.ronda == configuracion.rondas) {
            gameFinished = true
        } else {
            estadoJuego.ronda = estadoJuego.ronda + 1
        }
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
    fun respuestaCorrecta(answerIndex: Int): Boolean {
        return getUserAnswer(answerIndex) == getCorrectAnswer()
    }
    fun updateQuestionIndex() {
        var valid = false
        while (!valid) {
            randomQuestionIndex()
            if (getEnunciadoActual() !in enunciadosUsados) {
                valid = true
            }
        }
    }
    fun resetGame() {
        resetBackgroundAnswersColor()
        resetScore()
        modRonda(1)
        gameFinished = false
        gameStarted = false
        timerProgress = 0f
    }
    var gameStarted by mutableStateOf(false)
        private set
    fun startGame() {
        gameStarted = true
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
    val enunciadosUsados by mutableStateOf(mutableListOf<String>())

    fun getTiempo():Int {
        return configuracion.tiempo
    }
    private val INTERVAL = 1000L
    val timerDuration = getSliderTiempo() * INTERVAL
    var timerProgress by mutableFloatStateOf(0.0f)
    private var timer = object : CountDownTimer(timerDuration, INTERVAL) {
        override fun onTick(millisUntilFinished: Long) {
            timerProgress = 1.0f - (millisUntilFinished.toFloat() / timerDuration.toFloat())
            restarTiempo()
        }
        override fun onFinish() {
            if (getRound() <= getRounds()) {
                enunciadosUsados.add(getEnunciadoActual())
                updateQuestionIndex()
            }
            nextRound()
            modTiempo(getSliderTiempo())
        }
    }
    fun startTimer() {
        timer?.start()
    }

    fun cancelTimer() {
        timer?.cancel()
    }

    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }
}
