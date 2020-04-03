package com.bhd.milestone2task1

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure7_28 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure7_28)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure7_28_main_layout)

        val random = randomInt(5) + 2

        for (i in (0..random)){
            mainLayout.addView(getBaseAsset(false))
        }

        for (i in (random..10)){
            mainLayout.addView(getBaseAsset(true))
        }
    }

    fun getBaseAsset(isHaveLine: Boolean): View {
        val asset = layoutInflater.inflate(R.layout.figure7_25_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure7_25_text)
        text1.text = randomText(10)

        val line = asset.findViewById<TextView>(R.id.figure7_25_line)

        if (isHaveLine) {
            line.visibility = TextView.VISIBLE
        } else {
            line.visibility = TextView.INVISIBLE
        }

        return asset
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length - 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }
}
