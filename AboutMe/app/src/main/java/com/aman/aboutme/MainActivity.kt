package com.aman.aboutme

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

lateinit var btn : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)
        btn.setOnClickListener{setText(it)}
        findViewById<TextView>(R.id.textView).setOnClickListener {
            updateNickname(it)
        }
    }
    private fun setText(view: View)
    {
        val txt : EditText = findViewById(R.id.editTextTextPersonName)
        val txt2 : TextView = findViewById(R.id.textView)
        txt2.setTextColor(getResources().getColor(R.color.green))
        txt2.text = "Welcome\n"+txt.text
        if(txt.text.toString().equals("")) {
            txt2.text = "Welcome"
        }
        txt.visibility = View.GONE
        btn.visibility = View.GONE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val txt2 : TextView = findViewById(R.id.textView)
        txt2.setTextColor(getResources().getColor(R.color.white))
        editText.visibility = View.VISIBLE
        btn.visibility = View.VISIBLE
        editText.requestFocus()
        editText.getText().clear()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}