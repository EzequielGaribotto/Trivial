package com.example.trivial.model

data class Preguntas (
    var statement:String = "1 + 1",
    var answers:Array<String> = arrayOf("2","3","4","8"),
    var correctAnswer:String = "2",
    var points:Int = 1
)

