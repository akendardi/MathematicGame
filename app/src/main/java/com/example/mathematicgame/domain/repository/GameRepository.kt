package com.example.mathematicgame.domain.repository

import com.example.mathgame.domain.entities.GameSettings
import com.example.mathgame.domain.entities.Level
import com.example.mathgame.domain.entities.Question

//Наша игра должна уметь создавать вопрос и получать настройки игры,
//именно это мы и делаем в репозитории
interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}