package com.aman.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.NumberFormatException

var  t : Toast? = null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById<Button>(R.id.roll_button)
        val countButton: Button = findViewById<Button>(R.id.count_button)
        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener{ countUp() }
    }
    private fun rollDice()
    {
        t?.cancel()
        val random : Int = (1..6).random()
        val greeting_message : TextView = findViewById<TextView>(R.id.greeting_text)
        greeting_message.text  = random.toString()
        t = Toast.makeText(this, "Dice Rolled!",
            Toast.LENGTH_SHORT)
        t?.show()
    }
    private fun countUp()
    {
        val greeting_message : TextView = findViewById<TextView>(R.id.greeting_text)
        try{
            val num = Integer.parseInt(greeting_message.text.toString());
            greeting_message.text = (num+1).toString()
        }
        catch(e:NumberFormatException)
        {
            greeting_message.text = "1";
        }
    }
}