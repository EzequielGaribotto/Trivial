package com.example.trivial.viewModel
import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivial.model.*

@SuppressLint("MutableCollectionMutableState")
class GameViewModel: ViewModel() {
    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set
    var estado: EstadoJuego by mutableStateOf(EstadoJuego())
        private set
    fun restarTiempo() {
        configuracion.tiempo--
    }
    fun setTiempo(value:Int) {
        configuracion.tiempo = value
    }

    var preguntas: Preguntas by mutableStateOf(Preguntas())
        private set

    fun resetScore() {
        estado.puntuacion = 0
    }

    fun getScore():Int {
        return estado.puntuacion
    }
    var gameFinished: Boolean by mutableStateOf(false)
        private set

    fun randomQuestionIndex() {
        estado.questionIndex = (0 until preguntas.enunciados.size).random()
    }

    fun nextRound() {
        if (estado.ronda == configuracion.rondas) {
            gameFinished = true
        } else {
            estado.ronda = estado.ronda + 1
        }
    }

    fun getRound():Int {
        return estado.ronda
    }

    fun getRounds():Int {
        return configuracion.rondas
    }

    fun getQuestionIndex():Int {
        return estado.questionIndex
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
    var gameStarted by mutableStateOf(false)
        private set
    fun resetGame() {
        resetBackgroundAnswersColor()
        resetScore()
        resetRonda()
        cancelTimer()
        gameFinished = false
        gameStarted = false
        timerProgress = 0f
    }

    fun resetRonda() {
        estado.ronda = 1
    }
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
        estado.puntuacion += preguntas.puntos[getQuestionIndex()]
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
    private var timer: CountDownTimer? = null
    var timerProgress by mutableFloatStateOf(0.0f)

    fun startTimer(settingsViewModel:SettingsViewModel) {
        val timerDuration = settingsViewModel.getSliderTiempo() * INTERVAL
        var timerProgress by mutableFloatStateOf(0.0f)
        timer = object : CountDownTimer(timerDuration, INTERVAL) {
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
                setTiempo(settingsViewModel.getSliderTiempo())
            }
        }
        timer?.start()
    }

    fun cancelTimer() {
        timer?.cancel()
    }

    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }
}
