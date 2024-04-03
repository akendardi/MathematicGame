package com.example.mathgame.domain.usecases

import com.example.mathematicgame.domain.repository.GameRepository
import com.example.mathgame.domain.entities.Question

//Юзкейс для создания вопроса, в контрукторе репозиторий, invoke позволяет вызывать функцию без создания
//еще одной функции
class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}