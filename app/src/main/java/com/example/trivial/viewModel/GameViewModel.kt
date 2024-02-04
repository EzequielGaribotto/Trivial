package com.example.trivial.viewModel
import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivial.R
import com.example.trivial.model.Configuracion
import com.example.trivial.model.EstadoJuego
import com.example.trivial.model.Preguntas

@SuppressLint("MutableCollectionMutableState")
class GameViewModel: ViewModel() {
    /**
     * Global
     */
    private var configuracion: Configuracion by mutableStateOf(Configuracion())

    private var preguntas: Preguntas by mutableStateOf(Preguntas())

    private var estado: EstadoJuego by mutableStateOf(EstadoJuego())

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



    fun switchTheme() {
        configuracion.darkMode.value = !configuracion.darkMode.value
    }

    fun isDarkMode():Boolean {
        return configuracion.darkMode.value
    }

    fun getDelayMillis():Int {
        return configuracion.delayMillis
    }

    fun setDelayMillis(delay:Int) {
        configuracion.delayMillis = delay
    }

    fun getGeografia(): MutableState<Boolean> {
        return configuracion.geografia
    }

    fun getDeportes(): MutableState<Boolean> {
        return configuracion.deportes
    }

    fun getHistoria(): MutableState<Boolean> {
        return configuracion.historia
    }

    fun getMatematicas(): MutableState<Boolean> {
        return configuracion.matematicas
    }

    fun getQuimica(): MutableState<Boolean> {
        return configuracion.quimica
    }

    fun getVideojuegos(): MutableState<Boolean> {
        return configuracion.videojuegos
    }



    fun switchGeografia() {
        configuracion.geografia.value = !configuracion.geografia.value
        if (!configuracion.geografia.value) {
            configuracion.notAllowedList.add(R.drawable.geografia)
        } else {
            configuracion.notAllowedList.remove(R.drawable.geografia)
        }
    }

    fun switchDeportes() {
        configuracion.deportes.value = !configuracion.deportes.value
        if (!configuracion.deportes.value) {
            configuracion.notAllowedList.add(R.drawable.deportes)
        } else {
            configuracion.notAllowedList.remove(R.drawable.deportes)
        }
    }

    fun switchHistoria() {
        configuracion.historia.value = !configuracion.historia.value
        if (!configuracion.historia.value) {
            configuracion.notAllowedList.add(R.drawable.historia)
        } else {
            configuracion.notAllowedList.remove(R.drawable.historia)
        }
    }

    fun switchMatematicas() {
        configuracion.matematicas.value = !configuracion.matematicas.value
        if (!configuracion.matematicas.value) {
            configuracion.notAllowedList.add(R.drawable.matematicas)
        } else {
            configuracion.notAllowedList.remove(R.drawable.matematicas)
        }
    }

    fun switchQuimica() {
        configuracion.quimica.value = !configuracion.quimica.value
        if (!configuracion.quimica.value) {
            configuracion.notAllowedList.add(R.drawable.quimica)
        } else {
            configuracion.notAllowedList.remove(R.drawable.quimica)
        }
    }

    fun switchVideojuegos() {
        configuracion.videojuegos.value = !configuracion.videojuegos.value
        if (!configuracion.videojuegos.value) {
            configuracion.notAllowedList.add(R.drawable.videojuegos)
        } else {
            configuracion.notAllowedList.remove(R.drawable.videojuegos)
        }
    }

    fun getNotAllowedList():MutableList<Int> {
        return configuracion.notAllowedList
    }


    /**
     * 02GameScreen.kt
     */

    fun getQuestionImage():Int {
        return preguntas.image[getQuestionIndex()]
    }
    var playing: Boolean by mutableStateOf(true)
        private set


    private var enunciadosUsados by mutableStateOf(mutableListOf<String>())

    private fun endGame() {
        playing = false
    }

    fun resetGame() {
        playing = true
        enunciadosUsados.clear()
        shuffleAnswers()
        resetGameParameters()
    }

    private fun resetGameParameters() {
        estado = EstadoJuego()
    }

    fun getRonda():Int {
        return estado.ronda
    }

    private fun nextRonda() {
        estado.ronda++
    }

    fun getEnunciadoActual():String {
        return preguntas.enunciados[getQuestionIndex()]
    }

    private fun getQuestionIndex():Int {
        if (estado.questionIndex == -1) {
            randomQuestionIndex()
        }
        return estado.questionIndex
    }

    fun getAnswer(answerIndex:Int):String {
        return preguntas.respuestas[getQuestionIndex()][answerIndex]
    }
    private fun getCorrectAnswer():String {
        return preguntas.respuestaCorrecta[getQuestionIndex()]
    }

    private fun respuestaCorrecta(answerIndex: Int): Boolean {
        return getAnswer(answerIndex) == getCorrectAnswer()
    }

    private var buttonEnabled by mutableStateOf(true)

    fun isButtonEnabled():Boolean{
        return buttonEnabled
    }

    fun enableButton() {
        buttonEnabled = true
    }

    fun disableButton() {
        buttonEnabled = false
    }


    private var showBackground by mutableStateOf(false)
    private fun randomQuestionIndex() {
        val puntos = when (getDificultad()) {
            "Fácil" -> 1
            "Normal" -> 2
            "Dificil" -> 3
            else -> 4
        }

        do {
            estado.questionIndex = (0 until preguntas.enunciados.size).random()
        } while (
            (preguntas.puntos[getQuestionIndex()] != puntos && puntos != 4) ||
            (preguntas.image[getQuestionIndex()] in configuracion.notAllowedList)
        )

    }

    fun getDificultadPregunta():String {
        return when (preguntas.puntos[getQuestionIndex()]) {
            1 -> "Facil"
            2 -> "Normal"
            else -> "Dificil"
        }

    }


    private fun updateQuestionIndex() {
        usarEnunciado()
        do {
            randomQuestionIndex()
        } while (getEnunciadoActual() in enunciadosUsados)
    }

    private fun usarEnunciado() {
        enunciadosUsados.add(getEnunciadoActual())
    }

    fun getAcertadas():Int {
        return estado.acertadas
    }
    private fun preguntaAcertada() {
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

    private fun updateScorePoints(score:Int) {
        estado.score += score
    }

    fun showBackgroundColor() {
        showBackground = true
    }

    fun hideBackgroundColor() {
        showBackground = false
    }

    fun getBackgroundColor(answerIndex: Int): Color {
        val color: Color =
            if (showBackground) {
                if (respuestaCorrecta(answerIndex)) {
                    if (!isDarkMode()) Color.Green else Color(0xFF66FF66) // Light Green in dark mode
                } else {
                    if (!isDarkMode()) Color.Red else Color(0xFFFF5555) // Light Red in dark mode
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

    fun nextQuestion() {
        updateQuestionIndex()
        nextRonda()

        if (getRonda() <= getRondas()) return
        endGame()
    }
}
