package com.aman.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun changeColor(view: View)
    {
        when(view.id)
        {
            R.id.box1 -> view.setBackgroundColor(Color.CYAN)
            R.id.box2 -> view.setBackgroundColor(Color.BLUE)
            R.id.box3 -> view.setBackgroundColor(Color.RED)
            R.id.box4 -> view.setBackgroundColor(Color.YELLOW)
            R.id.box5 -> view.setBackgroundColor(Color.GREEN)
            R.id.btn1 -> findViewById<TextView>(R.id.box3).setBackgroundColor(resources.getColor(R.color.my_maroon))
            R.id.btn2 -> findViewById<TextView>(R.id.box4).setBackgroundColor(resources.getColor(R.color.my_pink))
            R.id.btn3 -> findViewById<TextView>(R.id.box5).setBackgroundColor(resources.getColor(R.color.my_purple))
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
    private fun setListeners() {
        val boxOne = findViewById<TextView>(R.id.box1)
        val boxTwo = findViewById<TextView>(R.id.box2)
        val boxThree = findViewById<TextView>(R.id.box3)
        val boxFour = findViewById<TextView>(R.id.box4)
        val boxFive = findViewById<TextView>(R.id.box5)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val clickableViews: List<View> =
            listOf(
                boxOne, boxTwo, boxThree,
                boxFour, boxFive, btn1, btn2, btn3,rootConstraintLayout
            )
        for (item in clickableViews) {
            item.setOnClickListener { changeColor(it) }
        }
    }
}