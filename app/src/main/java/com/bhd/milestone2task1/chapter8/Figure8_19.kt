package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.random.Random

class Figure8_19 : AppCompatActivity() {
    val strSrc = arrayOf("GET LEARN", "GET TONED", "GET STRONG", "GET FOCUS")
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure8_19)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure8_19_main_layout)

        for (i in (0..strSrc.size - 1)){
            mainLayout.addView(getBaseAsset())
            index++
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure8_19_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure8_19_title)
        text1.text = strSrc[index]

        val text2 = asset.findViewById<TextView>(R.id.figure8_19_text)
        text2.text = randomText(10)

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
}