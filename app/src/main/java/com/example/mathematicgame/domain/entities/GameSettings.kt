package com.example.mathematicgame.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings (
    val maxSumValue: Int, //Максимальное значение суммы
    val minCountOfRightAnswers: Int,//Минимальное количество правильных ответов для победы
    val minPercentOfRightAnswers: Int,//Минимальный процент правильных ответов для победы
    val gameTimeInSeconds: Int//Время игры в секундах
): Parcelable