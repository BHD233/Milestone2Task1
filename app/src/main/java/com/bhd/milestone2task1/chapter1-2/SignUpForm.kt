package com.bhd.milestone2task1

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SignUpForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_form)

        val img = findViewById<ImageButton>(R.id.sign_up_back)
        img.setColorFilter(Color.WHITE)

        val passView = findViewById<EditText>(R.id.sign_up_pass)
        passView.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

    fun onShowButtonClicked(view: View){
        val passView = findViewById<EditText>(R.id.sign_up_pass)

        val button = view as Button

        if (button.text == "Show") {
            button.text = "Hide"
            passView.inputType = InputType.TYPE_CLASS_TEXT
        } else{
            button.text = "Show"
            passView.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    }
}