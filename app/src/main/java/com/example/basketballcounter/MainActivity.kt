package com.example.basketballcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val left3btn = findViewById<Button>(R.id.left3pointBut)
        val left2btn = findViewById<Button>(R.id.left2pointBut)
        val leftFTbtn = findViewById<Button>(R.id.leftFTBut)
        val right3btn = findViewById<Button>(R.id.right3pointBut)
        val right2btn = findViewById<Button>(R.id.right2pointBut)
        val rightFTbtn = findViewById<Button>(R.id.rightFTBut)
        val resetBtn = findViewById<Button>(R.id.resetBut)

        // handle the button clicks
        resetBtn.setOnClickListener {

        }
        left3btn.setOnClickListener {

        }
        left2btn.setOnClickListener {

        }
        leftFTbtn.setOnClickListener {

        }
        right3btn.setOnClickListener {

        }
        right2btn.setOnClickListener {

        }
        rightFTbtn.setOnClickListener {

        }

    }

}