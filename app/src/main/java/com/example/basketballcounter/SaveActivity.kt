package com.example.basketballcounter

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val coolButton = findViewById<Button>(R.id.coolBtn)
        var coolText = findViewById<TextView>(R.id.coolTxt)

        coolButton.setOnClickListener {
            coolText.visibility = View.VISIBLE
            coolButton.isClickable = false
            //TODO: figure out how to change the color of the button after it gets clicked (the comment below might be helpful but like maybe not idk)
//            coolButton.backgroundTintList = ColorStateList.valueOf()
        }
    }
}