package com.example.gamelog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gamelog.database.GameRepository
import com.example.gamelog.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddGameViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val scope = CoroutineScope(Dispatchers.Main)

    fun insertGame(game: Game) {
        scope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)
            }
        }
    }
}


