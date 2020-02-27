package com.bhd.milestone2task1

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import java.nio.channels.GatheringByteChannel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        var intent = Intent(this, ToggleMenu::class.java)
        startActivity(intent)


        getInterface()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toggle_menu, menu)
        return true
    }

    fun getInterface(){
        val layout = findViewById<LinearLayout>(R.id.mainActivityLayout)

        for(i in (0..11)){

            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.CENTER

            val button = Button(this)
            button.text = "Chapter " + i.toString()
            button.id = i

            button.layoutParams = params

            button.setOnClickListener(View.OnClickListener {
                it->
                val curButton = it as Button
                curButton.text = "Clicked"
            })

            layout.addView(button)
        }
    }

}
