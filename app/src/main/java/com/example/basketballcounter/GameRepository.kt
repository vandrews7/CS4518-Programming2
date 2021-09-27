package com.example.basketballcounter

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.basketballcounter.database.GameDatabase
import java.lang.IllegalStateException
import java.util.*

private const val DATABASE_NAME = "game-database"

class GameRepository private constructor(context: Context){

    private val database : GameDatabase = Room.databaseBuilder(
        context.applicationContext,
        GameDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val gameDao = database.gameDao()

    fun getGames(): List<Game> = gameDao.getGames()

    fun getAWins(): LiveData<List<Game>> = gameDao.getAWins()

    fun getBWins(): LiveData<List<Game>> = gameDao.getBWins()

    fun getGame(id: UUID): LiveData<Game?> = gameDao.getGame(id)

    companion object {
        private var INSTANCE: GameRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = GameRepository(context)
            }
        }

        fun get(): GameRepository {
            return INSTANCE ?:
            throw IllegalStateException("GameRepository must be initialized")
        }
    }

}