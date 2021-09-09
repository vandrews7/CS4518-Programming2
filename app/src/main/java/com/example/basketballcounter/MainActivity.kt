package com.example.basketballcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val left3btn = findViewById<Button>(R.id.Apoints3)
        val left2btn = findViewById<Button>(R.id.Apoints2)
        val leftFTbtn = findViewById<Button>(R.id.Afree)
        var scoreA = 0
        val txtScoreA = findViewById<TextView>(R.id.scoreA)
        val right3btn = findViewById<Button>(R.id.Bpoints3)
        val right2btn = findViewById<Button>(R.id.Bpoints2)
        val rightFTbtn = findViewById<Button>(R.id.Bfree)
        var scoreB = 0
        val txtScoreB = findViewById<TextView>(R.id.scoreB)
        val resetBtn = findViewById<Button>(R.id.reset)
        val winner = findViewById<Button>(R.id.winner)
        val winTxt = findViewById<TextView>(R.id.winnerDisp)
        var score = 0

        // handle the button clicks
        resetBtn.setOnClickListener {
            scoreA = 0
            scoreB = 0
            txtScoreA.text = scoreA.toString()
            txtScoreB.text = scoreB.toString()
        }
        left3btn.setOnClickListener {
            scoreA += 3
            txtScoreA.text = scoreA.toString()
        }
        left2btn.setOnClickListener {
            scoreA += 2
            txtScoreA.text = scoreA.toString()
        }
        leftFTbtn.setOnClickListener {
            scoreA += 1
            txtScoreA.text = scoreA.toString()
        }
        right3btn.setOnClickListener {
            scoreB += 3
            txtScoreB.text = scoreB.toString()
        }
        right2btn.setOnClickListener {
            scoreB += 2
            txtScoreB.text = scoreB.toString()
        }
        rightFTbtn.setOnClickListener {
            scoreB += 1
            txtScoreB.text = scoreB.toString()
        }

        winner.setOnClickListener {
            score = scoreA - scoreB
            when{
                score<0 -> winTxt.text = "Team B wins!"
                score>0 ->winTxt.text = "Team A wins!"
                else -> winTxt.text = "It's a tie!"
            }
        }

    }

}