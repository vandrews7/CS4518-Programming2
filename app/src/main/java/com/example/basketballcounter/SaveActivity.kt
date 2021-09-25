package com.example.basketballcounter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val EXTRA_A_SCORE = "com.example.basketballcounter.team_A_score"
private const val EXTRA_B_SCORE = "com.example.basketballcounter.team_B_score"
private const val EXTRA_COOL_CLICK = "com.example.basketballcounter.coolBtn_click"
private const val TAG = "SaveActivity"

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "called onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val coolButton = findViewById<Button>(R.id.coolBtn)
        var coolText = findViewById<TextView>(R.id.coolTxt)

        coolButton.setOnClickListener {
            setIsClickedResult(true)
            coolText.visibility = View.VISIBLE
            coolButton.isClickable = false
            //TODO: figure out how to change the color of the button after it gets clicked (the comment below might be helpful but like maybe not idk)
//            coolButton.backgroundTintList = ColorStateList.valueOf()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "called onDestroy()")
    }

    private fun setIsClickedResult(isButtonClicked: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_COOL_CLICK, isButtonClicked)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, scoreA: Int, scoreB: Int): Intent {
            return Intent(packageContext, SaveActivity::class.java).apply {
                putExtra(EXTRA_A_SCORE, scoreA)
                putExtra(EXTRA_B_SCORE, scoreB)
            }
        }
    }
}