package com.example.basketballcounter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class GameFragment: Fragment() {
    private lateinit var game: Game
    private lateinit var teamAfield: EditText
    private lateinit var teamBfield: EditText
    private lateinit var teamAscore: TextView
    private lateinit var teamBscore: TextView
    private lateinit var Abtn3: Button
    private lateinit var Abtn2: Button
    private lateinit var AbtnFree: Button
    private lateinit var Bbtn3: Button
    private lateinit var Bbtn2: Button
    private lateinit var BbtnFree: Button
    private lateinit var save: Button
    private lateinit var resetBtn: Button
    private lateinit var display: Button
    private lateinit var winnerBtn: Button
    private lateinit var winnerTxt: TextView


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        game = Game()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        teamAfield = view.findViewById(R.id.teamA) as EditText
        teamBfield = view.findViewById(R.id.teamB) as EditText
        teamAscore = view.findViewById(R.id.scoreA) as TextView
        teamBscore = view.findViewById(R.id.scoreB) as TextView
        Abtn3 = view.findViewById(R.id.Apoints3) as Button
        Abtn2 = view.findViewById(R.id.Apoints2) as Button
        AbtnFree = view.findViewById(R.id.Afree) as Button
        Bbtn3 = view.findViewById(R.id.Bpoints3) as Button
        Bbtn2 = view.findViewById(R.id.Bpoints2) as Button
        BbtnFree = view.findViewById(R.id.Bfree) as Button
        save = view.findViewById(R.id.saveBtn) as Button
        resetBtn = view.findViewById(R.id.reset) as Button
        display = view.findViewById(R.id.displayBtn) as Button
        winnerBtn = view.findViewById(R.id.winner) as Button
        winnerTxt = view.findViewById(R.id.winnerDisp) as TextView

        return view
    }



}