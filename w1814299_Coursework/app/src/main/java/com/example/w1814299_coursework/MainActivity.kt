package com.example.w1814299_coursework

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(){
    lateinit var popup: Button
    lateinit var mDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        popup = findViewById(R.id.AboutButton)
        mDialog = Dialog(this)
        val ngbtn = findViewById<Button>(R.id.newgameButton)
        ngbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,DiceGame::class.java)
        startActivity(intent)
        })




        popup.setOnClickListener(){
            mDialog.setContentView(R.layout.alert)
            mDialog.setCancelable(true)
            mDialog.setContentView(R.layout.alert)
            mDialog.show()
        }


        }

}

