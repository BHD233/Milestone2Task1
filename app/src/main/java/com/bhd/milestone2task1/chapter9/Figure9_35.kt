package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure9_35 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure9_35)

        getInterface()
    }


    fun getInterface(){
        val layout1 = findViewById<LinearLayout>(R.id.figure9_35_layout1)

        val random = randomInt(5) + 2

        for (i in (0..random)){
            layout1.addView(getBaseAsset(false))
        }

        val layout2 = findViewById<LinearLayout>(R.id.figure9_35_layout2)
        for (i in (random..30)){
            layout2.addView(getBaseAsset(true))
        }
    }

    fun getBaseAsset(isHaveLine: Boolean): View {
        val asset = layoutInflater.inflate(R.layout.figure9_35_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure9_35_text)
        text1.text = randomText(10)

        val line = asset.findViewById<LinearLayout>(R.id.figure9_35_line)

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