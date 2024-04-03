package com.example.mathgame.domain.entities

data class Question(
    val sum: Int,//Значения суммы
    val visibleNumber: Int,//Значение видимого числа
    val options: List<Int>//Варианты ответов
)
