package com.example.mathematicgame.domain.usecases

import com.example.mathematicgame.domain.entities.Level
import com.example.mathematicgame.domain.repository.GameRepository
import com.example.mathematicgame.domain.entities.GameSettings

//Юзкейс для получения настроек игры пользователя
class GetGameSettingsUseCase(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }

}