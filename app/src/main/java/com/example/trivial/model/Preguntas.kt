package com.example.trivial.model

import androidx.compose.ui.graphics.Color
import com.example.trivial.R

class Preguntas(
    var enunciados: MutableList<String> = mutableListOf(),
    var respuestas: MutableList<Array<String>> = mutableListOf(),
    var colorRespuesta: MutableList<Array<Color>> = mutableListOf(),
    var respuestaCorrecta: MutableList<String> = mutableListOf(),
    var puntos: MutableList<Int> = mutableListOf(),
    var image: MutableList<Int> = mutableListOf()
) {

    init {
        addQuestion(
            "What is the capital of France?",
            arrayOf("Paris", "London", "Berlin", "Madrid"),
            5,
            R.drawable.logo,
            "Paris"
        )
        addQuestion(
            "What is the largest planet in our solar system?",
            arrayOf("Jupiter", "Mars", "Earth", "Venus"),
            3,
            R.drawable.logo,
            "Jupiter"
        )
        addQuestion(
            "Who painted the Mona Lisa?",
            arrayOf("Leonardo da Vinci", "Vincent van Gogh", "Michelangelo", "Rembrandt"),
            4,
            R.drawable.logo,
            "Leonardo da Vinci"
        )
        addQuestion(
            "¿En qué año se descubrió la penicilina?",
            arrayOf("1928", "1945", "1905", "1889"),
            4,
            R.drawable.logo,
            "1928"
        )
        addQuestion(
            "¿En qué año se produjo la caída del Muro de Berlín?",
            arrayOf("1989", "1990", "1991", "1992"),
            4,
            R.drawable.logo,
            "1989"
        )
        addQuestion(
            "¿Cuál es la capital de Australia?",
            arrayOf("Canberra", "Sídney", "Melbourne", "Perth"),
            4,
            R.drawable.logo,
            "Canberra"
        )
        addQuestion(
            "¿Quién escribió la novela 'Don Quijote de la Mancha'?", arrayOf(
                "Miguel de Cervantes",
                "William Shakespeare",
                "Dante Alighieri",
                "Johann Wolfgang von Goethe"
            ), 4, R.drawable.logo, "Miguel de Cervantes"
        )
        addQuestion(
            "¿Cuál es el río más largo del mundo?",
            arrayOf("Amazonas", "Nilo", "Yangtze", "Mississippi"),
            4,
            R.drawable.logo,
            "Amazonas"
        )
        addQuestion(
            "¿En qué año se descubrió América?",
            arrayOf("1492", "1502", "1512", "1522"),
            4,
            R.drawable.logo,
            "1492"
        )
        addQuestion(
            "¿Cuál es el teorema de Pitágoras?", arrayOf(
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos",
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual al producto de los catetos",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual a la suma de los cuadrados de la hipotenusa y el otro cateto",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual al producto de la hipotenusa y el otro cateto"
            ), 4, R.drawable.logo, "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos"
        )
        addQuestion(
            "¿Quién fue el primer hombre en pisar la Luna?",
            arrayOf(
                "Neil Armstrong", "Buzz Aldrin", "Michael Collins", " Yuri Gagarin"),
            4, R.drawable.logo, "Neil Armstrong"
        )
        addQuestion ("¿Cuál es la montaña más alta del mundo?",
            arrayOf("Monte Everest", "K2", "Kangchenjunga", "Lhotse"),
            4,
            R.drawable.logo,
            "Monte Everest"
        )
    }

    private fun addQuestion(
        enunciado: String,
        respuestas: Array<String>,
        puntos: Int,
        image: Int,
        respuestaCorrecta: String
    ) {
        this.enunciados.add(enunciado)
        this.respuestas.add(respuestas)
        this.colorRespuesta.add(Array(respuestas.size) { Color.White })
        this.respuestaCorrecta.add(respuestaCorrecta)  // Assuming the first answer is correct
        this.image.add(image)
        this.puntos.add(puntos)
    }
}

