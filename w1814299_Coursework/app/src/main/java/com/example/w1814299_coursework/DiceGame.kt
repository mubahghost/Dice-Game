package com.example.w1814299_coursework


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class DiceGame : AppCompatActivity() {
    //var diceNumbers = mutableListOf<Int>()
    val diceroll = findViewById<Button>(R.id.RollButton)
    var count :Int = 0
    var ScoreHuman :Int = 0
    var Scorecomputer :Int = 0
    lateinit var diceCollection: Array<Int>
    lateinit var diceNumber: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diceCollection = arrayOf(R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6)
        setContentView(R.layout.activity_dice_game)
        diceroll.text = getString(R.string.Roll)
        diceroll.setOnClickListener {
           var dice1 = RollingDice(R.drawable.dice1)
            var dice2 = RollingDice2(R.drawable.dice2)
            var dice3 = RollingDice3(R.drawable.dice3)
            var dice4 = RollingDice4(R.drawable.dice4)
            var dice5 = RollingDice5(R.drawable.dice5)
        }

    }
     fun RollingDice(dice1:ImageView):Int {

        val randomInt = Random().nextInt(6) + 1
        when (randomInt) {
            1 -> dice1.setImageResource(R.drawable.dice1)
            2 -> dice1.setImageResource(R.drawable.dice2)
            3 -> dice1.setImageResource(R.drawable.dice3)
            4 -> dice1.setImageResource(R.drawable.dice4)
            5 -> dice1.setImageResource(R.drawable.dice5)
            else -> dice1.setImageResource(R.drawable.dice6)

        }
        return randomInt
    }
     fun RollingDice2() {
        val randomInt = Random().nextInt(6) + 1
       // diceNumbers.add(randomInt)
        val img = findViewById<ImageView>(R.id.dice2)
        when (randomInt) {
            1 -> img.setImageResource(R.drawable.dice1)
            2 -> img.setImageResource(R.drawable.dice2)
            3 -> img.setImageResource(R.drawable.dice3)
            4 -> img.setImageResource(R.drawable.dice4)
            5 -> img.setImageResource(R.drawable.dice5)
            else -> img.setImageResource(R.drawable.dice6)
        }
    }
     fun RollingDice3() {
        val randomInt = Random().nextInt(6) + 1
        //diceNumbers.add(randomInt)
        val img = findViewById<ImageView>(R.id.dice3)
        when (randomInt) {
            1 -> img.setImageResource(R.drawable.dice1)
            2 -> img.setImageResource(R.drawable.dice2)
            3 -> img.setImageResource(R.drawable.dice3)
            4 -> img.setImageResource(R.drawable.dice4)
            5 -> img.setImageResource(R.drawable.dice5)
            else -> img.setImageResource(R.drawable.dice6)
        }
    }
     fun RollingDice4() {
        val randomInt = Random().nextInt(6) + 1
       // diceNumbers.add(randomInt)
        val img = findViewById<ImageView>(R.id.dice4)
        when (randomInt) {
            1 -> img.setImageResource(R.drawable.dice1)
            2 -> img.setImageResource(R.drawable.dice2)
            3 -> img.setImageResource(R.drawable.dice3)
            4 -> img.setImageResource(R.drawable.dice4)
            5 -> img.setImageResource(R.drawable.dice5)
            else -> img.setImageResource(R.drawable.dice6)
        }
    }
     fun RollingDice5() {
        val randomInt = Random().nextInt(6) + 1
       // diceNumbers.add(randomInt)
        val img = findViewById<ImageView>(R.id.dice5)
        when (randomInt) {
            1 -> img.setImageResource(R.drawable.dice1)
            2 -> img.setImageResource(R.drawable.dice2)
            3 -> img.setImageResource(R.drawable.dice3)
            4 -> img.setImageResource(R.drawable.dice4)
            5 -> img.setImageResource(R.drawable.dice5)
            else -> img.setImageResource(R.drawable.dice6)
        }
}
}