package com.example.mathematicgame.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val winner: Boolean, //Победили мы или нет
    val countOfRightAnswers: Int,//Количество правильных ответов
    val countOfQuestions: Int,//Общее количество вопросов
    val gameSettings: GameSettings//Настройки игры
):Parcelable
