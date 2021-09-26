package com.example.basketballcounter

import java.util.*

data class Game(val id: UUID = UUID.randomUUID(),
                var teamAname: String = "",
                var teamBname: String = "",
                var scoreA: Int = 0,
                var scoreB: Int = 0,
) {
}