package com.example.mathgame.domain.entities

data class GameSettings (
    val maxSumValue: Int, //Максимальное значение суммы
    val minCountOfRightAnswers: Int,//Минимальное количество правильных ответов для победы
    val minPercentOfRightAnswers: Int,//Минимальный процент правильных ответов для победы
    val gameTimeInSeconds: Int//Время игры в секундах
)