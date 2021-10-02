package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

/**
 * This activity allows the user to roll a dice and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Roll dice on launch
        rollDice()
    }

    /**
     * Roll a dice and set the result on screen
     */
    private fun rollDice() {
        // Set number of sides for the dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Show the resulting roll on screen
        val drawableResult = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val result: ImageView = findViewById(R.id.ivResult)
        result.setImageResource(drawableResult)
    }
}

class Dice(val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}