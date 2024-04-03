package com.example.mathgame.domain.usecases

import com.example.mathgame.domain.entities.GameSettings
import com.example.mathgame.domain.entities.Level
import com.example.mathgame.domain.repository.GameRepository
//Юзкейс для получения настроек игры пользователя
class GetGameSettingsUseCase(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }

}