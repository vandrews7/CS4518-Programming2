package com.example.basketballcounter

import androidx.lifecycle.ViewModel
import java.util.*

class GameListViewModel : ViewModel() {
    val games = mutableListOf<Game>()

    init {
        for(i in 0 until 100) {
            val game = Game()
            game.index = "Game #$i"
            game.scoreA = 0
            game.scoreB = 0
            game.teamAname = "TeamA"
            game.teamBname = "TeamB"
            game.date = Date()
            games += game
        }
    }
}