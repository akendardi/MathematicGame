package com.example.mathematicgame.data

import com.example.mathematicgame.domain.repository.GameRepository
import com.example.mathgame.domain.entities.GameSettings
import com.example.mathgame.domain.entities.Level
import com.example.mathgame.domain.entities.Question
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

//Объект репозитория, тут пишется вся логика репозитория
object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1) //Ответ на пример
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)//Видимое число
        val options = HashSet<Int>()//Множество ответов
        val rightAnswer = sum - visibleNumber//Нужный нам ответ
        options.add(rightAnswer)
        val from =
            max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)//Создаем нижнюю границу ответов
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)//Верхняя граница ответов
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(
                10,
                3,
                50,
                8
            )

            Level.EASY -> GameSettings(
                10,
                10,
                70,
                60
            )

            Level.MEDIUM -> GameSettings(
                20,
                20,
                80,
                40
            )

            Level.HARD -> GameSettings(
                30,
                30,
                90,
                40
            )
        }
    }
}