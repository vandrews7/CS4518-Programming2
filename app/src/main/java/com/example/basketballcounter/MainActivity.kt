package com.example.basketballcounter

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private const val REQUEST_CODE = 0

class MainActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "called onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val left3btn = findViewById<Button>(R.id.Apoints3)
        val left2btn = findViewById<Button>(R.id.Apoints2)
        val leftFTbtn = findViewById<Button>(R.id.Afree)
        val txtScoreA = findViewById<TextView>(R.id.scoreA)
        val right3btn = findViewById<Button>(R.id.Bpoints3)
        val right2btn = findViewById<Button>(R.id.Bpoints2)
        val rightFTbtn = findViewById<Button>(R.id.Bfree)
        val txtScoreB = findViewById<TextView>(R.id.scoreB)
        val resetBtn = findViewById<Button>(R.id.reset)
        val winner = findViewById<Button>(R.id.winner)
        val winTxt = findViewById<TextView>(R.id.winnerDisp)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val displayBtn = findViewById<Button>(R.id.displayBtn)

        if(!this.isFinishing && (scoreViewModel.getScoreA() > 0 || scoreViewModel.getScoreB() > 0)) {
            Log.i(TAG, "Persisting score across screen rotation")
            txtScoreA.text = scoreViewModel.getScoreA().toString()
            txtScoreB.text = scoreViewModel.getScoreB().toString()
            if(scoreViewModel.getWinPressed() > 0) {
                print(scoreViewModel.getWinPressed())
                winTxt.text = scoreViewModel.getScore()
            }
        }

        // handle the button clicks
        resetBtn.setOnClickListener {
            txtScoreA.text = scoreViewModel.resetScoreA()
            txtScoreB.text = scoreViewModel.resetScoreB()
            scoreViewModel.resetWinPressed()
            winTxt.text = ""
        }
        left3btn.setOnClickListener {
            txtScoreA.text = scoreViewModel.addScoreA(3)
        }
        left2btn.setOnClickListener {
            txtScoreA.text = scoreViewModel.addScoreA(2)
        }
        leftFTbtn.setOnClickListener {
            txtScoreA.text = scoreViewModel.addScoreA(1)
        }
        right3btn.setOnClickListener {
            txtScoreB.text = scoreViewModel.addScoreB(3)
        }
        right2btn.setOnClickListener {
            txtScoreB.text = scoreViewModel.addScoreB(2)
        }
        rightFTbtn.setOnClickListener {
            txtScoreB.text = scoreViewModel.addScoreB(1)
        }
        winner.setOnClickListener {
            winTxt.text = scoreViewModel.getScore()
        }
        saveBtn.setOnClickListener {
            Log.i(TAG, "save button clicked, switching to SaveActivity")
            val intent = SaveActivity.newIntent(this@MainActivity, scoreViewModel.getScoreA(), scoreViewModel.getScoreB())
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "called onDestroy()")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i(TAG, "called onActivityResult()")
        super.onActivityResult(requestCode, resultCode, data)

        Log.d(TAG, "resultCode = $resultCode")
        if(resultCode != Activity.RESULT_OK) {
            return
        }

        val isCoolClick = data?.getBooleanExtra(EXTRA_COOL_CLICK, false)
        Log.d(TAG, "requestCode = $requestCode")
        Log.d(TAG, "extra_cool_click = $isCoolClick")

        if(requestCode == REQUEST_CODE) {
            scoreViewModel.savePressed = isCoolClick ?: false
        }
        Log.d(TAG, "savePressed = ${scoreViewModel.savePressed}")

        if(scoreViewModel.savePressed) {
            Toast.makeText(
                this,
                R.string.save_toast,
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("scoreA", scoreViewModel.getScoreA())
        savedInstanceState.putInt("scoreB", scoreViewModel.getScoreB())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        //TODO: fix this so it does something lmao
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getInt("scoreA")
        savedInstanceState.getInt("scoreB")
    }
}