package com.example.w1814299_coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class DiceGame : AppCompatActivity() {
    //Player dices
    lateinit var dice1: ImageView
    lateinit var dice2: ImageView
    lateinit var dice3: ImageView
    lateinit var dice4: ImageView
    lateinit var dice5: ImageView

    // computer dices
    lateinit var dice1C: ImageView
    lateinit var dice2C: ImageView
    lateinit var dice3C: ImageView
    lateinit var dice4C: ImageView
    lateinit var dice5C: ImageView

    //variable Button for dice roll and score
    lateinit var diceroll: Button
    lateinit var scoreButton: Button
    lateinit var reRoll: Button

    //set the dice boolean to false player to allow reroll
    var dice1Boolean: Boolean = false
    var dice2Boolean: Boolean = false
    var dice3Boolean: Boolean = false
    var dice4Boolean: Boolean = false
    var dice5Boolean: Boolean = false

    //score variable for human player
    var ScoreHuman: Int = 0

    //score variable for computer
    var Scorecomputer: Int = 0

    //this tallies up the total score for player
    var playerscoretotal: Int = 0

    //this tallies up the total score for Computer
    var computerscoretotal: Int = 0

    //total score variable used to set the targets
    var totalscores: Int = 0
    var playerRoll: Int = 0

    //array for dice storing images
    lateinit var diceCollection: Array<ImageView>

    //array for storing diceComputer images
    lateinit var diceCollectionComp: Array<ImageView>

    //array for storing the dices for player
    lateinit var dices: Array<Int>

    //array for storing the dices for computer
    lateinit var dicesComp: Array<Int>

    //arraylist for player score and set to an INT
    lateinit var playerScore: ArrayList<Int>

    //arraylist for Computer score and set to an INT
    lateinit var compScore: ArrayList<Int>

    //Random num has been set to random
    lateinit var randomNum: Random

    //playertxt to add scores onto
    lateinit var playerTxt: TextView

    //Comptxt to add scores onto
    lateinit var compTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_game)

        //totalscores has been assigned to an intent from choose score activity and has been set default value of 0
        totalscores = intent.getIntExtra("target", 0)

        //diceImages have been initialised
        dice1 = findViewById<ImageView>(R.id.dice1)
        dice2 = findViewById<ImageView>(R.id.dice2)
        dice3 = findViewById<ImageView>(R.id.dice3)
        dice4 = findViewById<ImageView>(R.id.dice4)
        dice5 = findViewById<ImageView>(R.id.dice5)

        //diceImages for computer have been initialised
        dice1C = findViewById<ImageView>(R.id.dice1c)
        dice2C = findViewById<ImageView>(R.id.dice2c)
        dice3C = findViewById<ImageView>(R.id.dice3c)
        dice4C = findViewById<ImageView>(R.id.dice4c)
        dice5C = findViewById<ImageView>(R.id.dice5c)

        //player score and comp score have been set to arraylists and we are using them to either call them or clear the arraylist.
        playerScore = ArrayList()
        compScore = ArrayList()

        //scoreButton initialised
        scoreButton = findViewById<Button>(R.id.ScoreButton)
        reRoll = findViewById<Button>(R.id.Reroll)
        scoreButton.visibility = View.INVISIBLE

        diceCollection = arrayOf(dice1, dice2, dice3, dice4, dice5)
        playerScore = ArrayList()
        //initialising the playertxt variable which holds the result of the player.
        playerTxt = findViewById<TextView>(R.id.resultplayer)

        //assigning the dices to the array
        dices = arrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )
        //dices being assinged to an array
        diceCollectionComp = arrayOf(dice1C, dice2C, dice3C, dice4C, dice5C)
        compScore = ArrayList()

        //initialising the playertxt variable which holds the result of the player.
        compTxt = findViewById<TextView>(R.id.resultComp)

        //assigning the dices for computer to the array
        dicesComp = arrayOf(
            R.drawable.dice1c,
            R.drawable.dice2c,
            R.drawable.dice3c,
            R.drawable.dice4c,
            R.drawable.dice5c,
            R.drawable.dice6c
        )

        randomNum = Random()
        //diceroll has been initialised and set to RollButton
        diceroll = findViewById<Button>(R.id.RollButton)

        diceroll.setOnClickListener() {
            rollDicePlayer()
            rollDiceComp()
            scoreButton.visibility = View.VISIBLE
        }
        //score button used to display all the scores aswell as clear the scores because we only want to tally up the most recent scores and not add on the old scores.
        //display winner and loser function added here which carries out intent statements
        scoreButton.setOnClickListener() {
            playerScore()
            comScore()
            displayScore()
            playerScore.clear()
            compScore.clear()
            displayWinnerOrloser()
        }

        //Setting each dice onclick listener and setting its value to true
        dice1.setOnClickListener() {
            dice1Boolean = true
        }
        dice2.setOnClickListener() {
            dice2Boolean = true
        }
        dice3.setOnClickListener() {
            dice3Boolean = true
        }
        dice4.setOnClickListener() {
            dice4Boolean = true
        }
        dice5.setOnClickListener() {
            dice5Boolean = true
        }

        //reroll set on click listener with if statements to check if dices have been selected they are also set to false.
        reRoll.setOnClickListener() {
            //increment for player roll is added and counts the amount of dices selected for reroll.
            playerRoll++
            if (playerRoll < 2) {
                if (!dice1Boolean) {
                    playerScore.removeAt(0)
                    reRollplayer(dice1, 0)
                    dice1Boolean = false
                }


                if (!dice2Boolean) {
                    playerScore.removeAt(1)
                    reRollplayer(dice2, 1)
                    dice2Boolean = false
                }


                if (!dice3Boolean) {
                    playerScore.removeAt(2)
                    reRollplayer(dice3, 2)
                    dice3Boolean = false
                }



                if (!dice4Boolean) {
                    playerScore.removeAt(3)
                    reRollplayer(dice4, 3)
                    dice4Boolean = false

                }


                if (!dice5Boolean) {
                    playerScore.removeAt(4)
                    reRollplayer(dice5, 4)
                    dice5Boolean = false
                }
            }
            //if statemetns to allow the computer to do a reroll or to carry on and to check for amount of rerolls of player
            if (playerRoll == 2) {
                playerScore()
                comScore()
                displayScore()
            }
            //randomnum variable has been used for the computer
            var rerollComp = randomNum.nextBoolean()

            if (rerollComp) {
                for (i in diceCollectionComp) {
                    reRollComp()
                }
                comScore()

            }
        }
    }


    //function to roll the dice for player
    fun rollDicePlayer() {
        for (i in diceCollection) {
            val num = randomNum.nextInt(6)
            i.setImageResource(dices[num])
            playerScore.add(num + 1)

        }

    }

    //function to roll dice for computer. its randomised as its a computer making the moves
    fun rollDiceComp() {
        for (i in diceCollectionComp) {
            val num = randomNum.nextInt(6)
            i.setImageResource(dicesComp[num])
            compScore.add(num + 1)
        }
    }

    //function to display the scores. here the txt variables are used and i add the scores for player and computer to it
    fun displayScore() {
        playerTxt.setText("Player: " + playerscoretotal)
        compTxt.setText("Computer: " + computerscoretotal)
        //attempt at figuring out what happens if it draws
        if (Scorecomputer > totalscores || ScoreHuman > totalscores) {

        }
        //clears the scores so that new round can start fresh
        playerScore.clear()
        compScore.clear()
    }

    //function to add to computer score
    fun comScore() {
        for (i in compScore) {
            computerscoretotal += i
        }
    }

    //function to add to player score
    fun playerScore() {
        for (i in playerScore) {
            playerscoretotal += i
        }
    }

    //function to display winner and loser using intents and checks the scores using if statements.
    fun displayWinnerOrloser() {
        if (playerscoretotal >= totalscores) {
            val intent = Intent(this, winscreen::class.java)
            startActivity(intent)
        }
        if (computerscoretotal >= totalscores) {
            val intent = Intent(this, loseScreen::class.java)
            startActivity(intent)

        }


    }

    //function to allow a player to reroll
    fun reRollplayer(dice: ImageView, number: Int) {
        var num = randomNum.nextInt(6)
        dice.setImageResource(dices[num])
        playerScore.add(number, num + 1)
    }

    //function to allow the computer to reroll
    fun reRollComp() {
        for (i in diceCollectionComp) {
            var num = randomNum.nextInt(6)
            i.setImageResource(dicesComp[num])
            compScore.add(num + 1)
        }
        compScore.clear()
    }

}