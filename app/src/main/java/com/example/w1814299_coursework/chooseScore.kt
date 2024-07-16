package com.example.w1814299_coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class chooseScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_score)
        //buttons have been initalised and an intent has been added
        val ngbtn100 = findViewById<Button>(R.id.button100)
        ngbtn100.setOnClickListener(View.OnClickListener {
            Intent(this, DiceGame::class.java).also {
                it.putExtra("target", 101)
                startActivity(it)
            }
        })

        val ngbtn150 = findViewById<Button>(R.id.button150)
        ngbtn150.setOnClickListener(View.OnClickListener {
            Intent(this, DiceGame::class.java).also {
                it.putExtra("target", 151)
                startActivity(it)
            }
        })

        val ngbtn200 = findViewById<Button>(R.id.button200)
        ngbtn200.setOnClickListener(View.OnClickListener {
            Intent(this, DiceGame::class.java).also {
                it.putExtra("target", 201)
                startActivity(it)
            }
        })

        val ngbtn250 = findViewById<Button>(R.id.button250)
        ngbtn250.setOnClickListener(View.OnClickListener {
            Intent(this, DiceGame::class.java).also {
                it.putExtra("target", 251)
                startActivity(it)
            }
        })

        val backbtn = findViewById<Button>(R.id.backbutton4)
        backbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }

}
