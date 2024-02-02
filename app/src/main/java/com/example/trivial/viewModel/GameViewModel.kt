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
import com.example.trivial.view.columnas
import com.example.trivial.view.filas

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

    fun enableButton() {
        buttonEnabled = true
    }

    fun disableButton() {
        buttonEnabled = false
    }


    var showBackground by mutableStateOf(false)
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





    fun randomAnswerIndex():Int {
        return (0 until filas * columnas).random()
    }

    fun randomizeAnswer(answerIndex: Int, respuestasMostradas:MutableList<Int>):Int {
        var answer = answerIndex
        while (answer in respuestasMostradas) {
            answer = randomAnswerIndex()
        }
        respuestasMostradas.add(answer)
        return answer
    }
    fun updateScore(answerIndex:Int){
        if (respuestaCorrecta(answerIndex))
            estado.score += preguntas.puntos[getQuestionIndex()]
    }
    fun getScore():Int {
        return estado.score
    }


    fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }

    fun showBackgroundColor() {
        showBackground = true
    }

    fun hideBackgroundColor() {
        showBackground = false
    }

    fun getBackgroundColor(answerIndex:Int):Color {
        val color:Color = if (showBackground) {
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

    fun nextQuestion() {
        usarEnunciado()
        updateQuestionIndex()

        setTiempo(getSliderTime())

        nextRonda()

        if (getRonda() <= getRondas()) return
        endGame()
    }
}
