package com.example.trivial.viewModel
import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas

@SuppressLint("MutableCollectionMutableState")
class GameViewModel: ViewModel() {
    /**
     * Global
     */

    var preguntas: Preguntas by mutableStateOf(Preguntas())
        private set

    var estado: EstadoJuego by mutableStateOf(EstadoJuego())
        private set

    /**
     * 04SettingsScreen.kt
     */

    var darkMode:Boolean by mutableStateOf(false)
        private set

    fun switchTheme() {
        darkMode = !darkMode
    }
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

    fun getSliderTime():Int {
        return configuracion.sliderTime
    }

    fun setRondas(value:Int) {
        configuracion.rondas = value
    }
    fun getRondas():Int {
        return configuracion.rondas
    }

    /**
     * 02GameScreen.kt
     */
    var playing: Boolean by mutableStateOf(true)
        private set

    var enunciadosUsados by mutableStateOf(mutableListOf<String>())
        private set

    private fun endGame() {
        playing = false
    }

    fun resetGame() {
        playing = true
        enunciadosUsados.clear()
        timerProgress = 0f

        resetRonda()
        resetScore()
        resetBackgroundAnswersColor()
    }

    fun resetRonda() {
        estado.ronda = 1
    }

    fun resetScore() {
        estado.score = 0
    }

    fun resetBackgroundAnswersColor() {
        preguntas.colorRespuesta = MutableList(preguntas.enunciados.size) { Array(4) { Color.White } }
    }

    fun getRonda():Int {
        return estado.ronda
    }

    fun nextRonda() {
        estado.ronda++
    }

    fun getTiempo():Int {
        return configuracion.tiempo
    }

    fun setTiempo(value:Int) {
        configuracion.tiempo = value
    }

    fun restarTiempo() {
        configuracion.tiempo--
    }

    fun getEnunciadoActual():String {
        return preguntas.enunciados[getQuestionIndex()]
    }

    fun getQuestionIndex():Int {
        return estado.questionIndex
    }

    fun getUserAnswer(answerIndex:Int):String {
        return preguntas.respuestas[getQuestionIndex()][answerIndex]
    }
    fun getCorrectAnswer():String {
        return preguntas.respuestaCorrecta[getQuestionIndex()]
    }

    fun respuestaCorrecta(answerIndex: Int): Boolean {
        return getUserAnswer(answerIndex) == getCorrectAnswer()
    }

    fun randomQuestionIndex() {
        estado.questionIndex = (0 until preguntas.enunciados.size).random()
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

    fun updateScore(){
        estado.score += preguntas.puntos[getQuestionIndex()]
    }
    fun getScore():Int {
        return estado.score
    }

    fun updateAnswerBackgroundColor(answerIndex:Int, color:Color) {
        preguntas.colorRespuesta[getQuestionIndex()][answerIndex] = color
    }

    fun getAnswerBackgroundColor(answerIndex: Int):Color {
        return preguntas.colorRespuesta[getQuestionIndex()][answerIndex]
    }

    fun getArrayAnswersSize():Int {
        return preguntas.respuestas.size
    }

    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }

    fun nextQuestion() {
        nextRonda()
        usarEnunciado()
        updateQuestionIndex()
        if (getRonda() > getRondas()) {
            endGame()
        }
        timerProgress = 0.0f
        setTiempo(getSliderTime())
        cancelTimer()
    }

    private var timer: CountDownTimer? = null
    var timerProgress by mutableFloatStateOf(0.0f)
    fun startTimer() {
        val timerDuration = getSliderTime() * INTERVAL
        timer = object : CountDownTimer(timerDuration, INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                timerProgress = 1.0f - (millisUntilFinished.toFloat() / timerDuration.toFloat())
                restarTiempo()
            }
            override fun onFinish() {
                nextQuestion()
            }
        }
        timer?.start()
    }
    companion object {
        private const val INTERVAL = 10L  // Intervalo de actualización en milisegundos (1 segundo)
    }

    fun cancelTimer() {
        timer?.cancel()
    }
}
