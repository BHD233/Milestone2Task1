package com.bhd.milestone2task1

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import java.nio.channels.GatheringByteChannel

class SearchForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_form)

        val icon = findViewById<ImageView>(R.id.personIcon)
        icon.setColorFilter(Color.WHITE)
    }

    fun onPlusButtonClicked(view: View){
        val textView = findViewById<TextView>(R.id.personTextView)
        var num = textView.text.toString().toInt()

        num++

        textView.text = num.toString()
    }

    fun onMinusButtonClicked(view: View){
        val textView = findViewById<TextView>(R.id.personTextView)
        var num = textView.text.toString().toInt()

        if (num > 1) {
            num--
        }

        textView.text = num.toString()
    }
}
