package com.example.basketballcounter
import android.os.Bundle
import androidx.fragment.app.Fragment

class GameFragment: Fragment() {
    private lateinit var game: Game()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        game = Game()
    }

}