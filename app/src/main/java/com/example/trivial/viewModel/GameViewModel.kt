package com.example.trivial.viewModel
import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
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
    var configuracion: Configuracion by mutableStateOf(Configuracion())
        private set

    var preguntas: Preguntas by mutableStateOf(Preguntas())
        private set

    var estado: EstadoJuego by mutableStateOf(EstadoJuego())
        private set

    /**
     * 04SettingsScreen.kt
     */

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

    fun setSliderTiempo(value:Int) {
        configuracion.sliderTime = value
    }

    fun getSliderTime():Int {
        return configuracion.sliderTime
    }

    var darkMode:Boolean by mutableStateOf(false)
        private set

    fun switchTheme() {
        darkMode = !darkMode
    }

    fun getDelayMillis():Int {
        return configuracion.delayMillis
    }

    fun setDelayMillis(delay:Int) {
        configuracion.delayMillis = delay
    }

    /**
     * 02GameScreen.kt
     */

    fun getQuestionImage():Int {
        return preguntas.image[getQuestionIndex()]
    }
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
        shuffleAnswers()
        resetGameParameters()
    }

    fun resetGameParameters() {
        estado.score = 0
        estado.ronda = 1
        estado.acertadas = 0
        estado.falladas = 0
    }

    fun getRonda():Int {
        return estado.ronda
    }

    fun nextRonda() {
        estado.ronda++
    }

    fun getEnunciadoActual():String {
        return preguntas.enunciados[getQuestionIndex()]
    }

    fun getQuestionIndex():Int {
        return estado.questionIndex
    }

    fun getAnswer(answerIndex:Int):String {
        return preguntas.respuestas[getQuestionIndex()][answerIndex]
    }
    fun getCorrectAnswer():String {
        return preguntas.respuestaCorrecta[getQuestionIndex()]
    }

    fun respuestaCorrecta(answerIndex: Int): Boolean {
        return getAnswer(answerIndex) == getCorrectAnswer()
    }

    var buttonEnabled by mutableStateOf(true)
        private set

    fun isButtonEnabled():Boolean{
        return buttonEnabled
    }

    fun enableButton() {
        buttonEnabled = true
    }

    fun disableButton() {
        buttonEnabled = false
    }


    var showBackground by mutableStateOf(false)
    fun randomQuestionIndex(dificultad:String) {
        val puntos = when (dificultad) {
            "Fácil" -> 1
            "Normal" -> 2
            else -> 3
        }
        do {
            estado.questionIndex = (0 until preguntas.enunciados.size).random()
        } while (preguntas.puntos[getQuestionIndex()] != puntos)
    }

    private fun updateQuestionIndex(dificultad: String) {
        usarEnunciado()
        do {
            randomQuestionIndex(dificultad)
        } while (getEnunciadoActual() in enunciadosUsados)
    }

    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }

    fun getAcertadas():Int {
        return estado.acertadas
    }
    fun preguntaAcertada() {
        estado.acertadas++
    }
    fun getFalladas():Int {
        return estado.falladas
    }
    fun preguntaFallada() {
        estado.falladas++
    }

    fun updateScore(answerIndex:Int){
        if (respuestaCorrecta(answerIndex)) {
            preguntaAcertada()
            updateScorePoints(preguntas.puntos[getQuestionIndex()])
        } else {
            preguntaFallada()
        }
    }
    fun getScore():Int {
        return estado.score
    }

    fun updateScorePoints(score:Int) {
        estado.score += score
    }

    fun showBackgroundColor() {
        showBackground = true
    }

    fun hideBackgroundColor() {
        showBackground = false
    }

    fun getBackgroundColor(answerIndex:Int):Color {
        val color:Color =
            if (showBackground) {
                if (respuestaCorrecta(answerIndex)) {
                    Color.Green
                } else {
                    Color.Red
                }
            } else {
                Color.Transparent
            }
        return color
    }

    private fun shuffleAnswers() {
        for (answers in preguntas.respuestas){
            answers.shuffle()
        }
    }

    fun nextQuestion(dificultad: String) {
        updateQuestionIndex(dificultad)
        nextRonda()

        if (getRonda() <= getRondas()) return
        endGame()
    }
}
