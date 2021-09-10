package com.example.basketballcounter

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel

private const val TAG = "ScoreViewModel"

class ScoreViewModel : ViewModel(){
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance is about to be destroyed")
    }

    private var scoreA = 0
    private var scoreB = 0

    fun resetScoreA(): String {
        scoreA = 0
        return scoreA.toString()
    }
    fun resetScoreB(): String {
        scoreB = 0
        return scoreB.toString()
    }
    fun getScoreA(): Int {
        return scoreA
    }
    fun getScoreB(): Int {
        return scoreB
    }
    fun addScoreA(value: Int): String{
        scoreA += value
        return scoreA.toString()
    }
    fun addScoreB(value: Int): String{
        scoreB += value
        return scoreB.toString()
    }

}