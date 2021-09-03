package com.example.basketballcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val left3btn = findViewById<Button>(R.id.left3pointBut)
        val left2btn = findViewById<Button>(R.id.left2pointBut)
        val leftFTbtn = findViewById<Button>(R.id.leftFTBut)
        var scoreA = 0
        val txtScoreA = findViewById<TextView>(R.id.textScoreA)
        val right3btn = findViewById<Button>(R.id.right3pointBut)
        val right2btn = findViewById<Button>(R.id.right2pointBut)
        val rightFTbtn = findViewById<Button>(R.id.rightFTBut)
        var scoreB = 0
        val txtScoreB = findViewById<TextView>(R.id.textScoreB)
        val resetBtn = findViewById<Button>(R.id.resetBut)

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

    }

}