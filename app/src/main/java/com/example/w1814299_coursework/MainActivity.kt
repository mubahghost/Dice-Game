// https://youtu.be/0kc9dZcZ4eU  ---> video link
package com.example.w1814299_coursework

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //variables declared
    lateinit var popup: Button
    lateinit var mDialog: Dialog
    lateinit var popup2: Button
    lateinit var rDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //variables initialised
        popup = findViewById<Button>(R.id.AboutButton)
        mDialog = Dialog(this)
        popup2 = findViewById<Button>(R.id.Rules)
        rDialog = Dialog(this)
        //scorebtn has been initialised and has been set to on click and takes you to choose the target you want to reach using intent.
        val scorebtn = findViewById<Button>(R.id.newgameButton)
        scorebtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, chooseScore::class.java)
            startActivity(intent)
        })
        //popup set on click listners and have called the relating layouts and set dialog to show so that the popup displays.
        popup.setOnClickListener() {
            mDialog.setContentView(R.layout.alert)
            mDialog.setCancelable(true)
            mDialog.setContentView(R.layout.alert)
            mDialog.show()
        }
        //popup2 set on click listners and have called the relating layouts and set dialog to show so that the popup displays.
        popup2.setOnClickListener() {
            rDialog.setContentView(R.layout.rulesalert)
            rDialog.setCancelable(true)
            rDialog.setContentView(R.layout.rulesalert)
            rDialog.show()
        }
    }

}

