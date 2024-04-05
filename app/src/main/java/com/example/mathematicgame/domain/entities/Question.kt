package com.example.mathematicgame.domain.entities

data class Question(
    val sum: Int,//Значения суммы
    val visibleNumber: Int,//Значение видимого числа
    val options: List<Int>//Варианты ответов
) {
    val rightAnswer = sum - visibleNumber
}
