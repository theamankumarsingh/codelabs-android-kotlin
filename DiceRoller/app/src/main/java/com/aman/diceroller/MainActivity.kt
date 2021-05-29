package com.aman.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


var  t : Toast? = null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countButton: Button = findViewById(R.id.turn_button)
        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener{ turn() }
    }
    private fun rollDice()
    {
        val random : Int = (1..6).random()
        val greetingmessage : TextView = findViewById(R.id.dice_number)
        greetingmessage.text  = random.toString()
        changeDice(random)
        toast("Dice Rolled!")
    }
    private fun turn()
    {
        val greetingmessage : TextView = findViewById(R.id.dice_number)
        var num = Integer.parseInt(greetingmessage.text.toString())
        try{
            if(num==6)
                num=0
            num++
        }
        catch(e:NumberFormatException)
        {
            num=1
        }
        greetingmessage.text = (num).toString()
        changeDice(num)
        toast("Dice Turned!")
    }
    private fun changeDice(n:Int)
    {
        val image : ImageView = findViewById(R.id.dice)
        var path = 1
        when(n)
        {
            1 -> path = R.drawable.dice_1
            2 -> path = R.drawable.dice_2
            3 -> path = R.drawable.dice_3
            4 -> path = R.drawable.dice_4
            5 -> path = R.drawable.dice_5
            6 -> path = R.drawable.dice_6
        }
        image.setImageResource(path)
    }
    @SuppressLint("ShowToast")
    private fun toast(txt:String)
    {
        t?.cancel()
        t = Toast.makeText(this, txt,
            Toast.LENGTH_SHORT)
        t?.setGravity(Gravity.BOTTOM,0,0)
        t?.show()
    }
}