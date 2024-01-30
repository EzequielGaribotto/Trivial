package com.example.trivial.viewModel
import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas

@SuppressLint("MutableCollectionMutableState")
class GameViewModel: ViewModel() {

    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set

    fun setDificultad(value:String) {
        configuracion.dificultad = value
    }

    fun getDificultad():String {
        return configuracion.dificultad
    }

    fun setSliderTiempo(value:Int) {
        configuracion.sliderTime = value
        setTiempo(value)
    }
    fun setRondas(value:Int) {
        configuracion.rondas = value
    }
    fun resetRonda() {
        estadoJuego.ronda = 1
    }
    fun restarTiempo() {
        configuracion.tiempo--
    }
    fun setTiempo(value:Int) {
        configuracion.tiempo = value
    }

    fun getSliderTiempo():Int {
        return configuracion.sliderTime
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

    fun getRonda():Int {
        return estadoJuego.ronda
    }

    fun getRondas():Int {
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
        resetRonda()
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
    private val enunciadosUsados by mutableStateOf(mutableListOf<String>())

    fun getTiempo():Int {
        return configuracion.tiempo
    }
    private val INTERVAL = 10L
    val timerDuration = getSliderTiempo() * INTERVAL
    var timerProgress by mutableFloatStateOf(0.0f)
    private var timer = object : CountDownTimer(timerDuration, INTERVAL) {
        override fun onTick(millisUntilFinished: Long) {
            timerProgress = 1.0f - (millisUntilFinished.toFloat() / timerDuration.toFloat())
            restarTiempo()
        }
        override fun onFinish() {
            nextQuestion()
        }
    }

    fun nextQuestion() {
        if (getRonda() <= getRondas()) {
            usarEnunciado()
            updateQuestionIndex()
        }
        timerProgress = 0.0f
        nextRound()
        setTiempo(getSliderTiempo())
        cancelTimer()
    }

    fun startTimer() {
        timer.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }

    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }
}
