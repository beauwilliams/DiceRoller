package com.hello.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 *  This class is the main activity in our app
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val luckyNumber = (1..dice.numSides).random()
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.result)
        resultTextView.text = diceRoll.toString()

        val luckyTextView: TextView = findViewById(R.id.luckyResult)
        when (diceRoll) {
            luckyNumber -> luckyTextView.text =  getString(R.string.result_success)
            1 -> luckyTextView.text =  getString(R.string.result_fail_1)
            2 -> luckyTextView.text =  getString(R.string.result_fail_2)
            3 -> luckyTextView.text =  getString(R.string.result_fail_3)
            4 -> luckyTextView.text =  getString(R.string.result_fail_4)
            5 -> luckyTextView.text =  getString(R.string.result_fail_5)
            6 -> luckyTextView.text =  getString(R.string.result_fail_6)
        }

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.diceImage)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}



/**
 *  This class will roll the dice for us
 */
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
