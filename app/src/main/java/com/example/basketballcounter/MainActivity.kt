package com.example.basketballcounter

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "called onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(currentFragment == null){
            val fragment = GameFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
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