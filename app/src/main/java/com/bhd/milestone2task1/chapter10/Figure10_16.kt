package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure10_16 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure10_16)

        getInterface()
    }

    fun getInterface(){
        var mainLayout = findViewById<LinearLayout>(R.id.figure10_16_layout1)

        var a = randomInt(2) + 2

        for (i in (0..a)){
            mainLayout.addView(getBaseAsset())
        }

        mainLayout = findViewById<LinearLayout>(R.id.figure10_16_layout2)

        a = randomInt(3) + 3

        for (i in (0..a)){
            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure10_16_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure10_16_text)
        text1.text = randomText(randomInt(10) + 5)

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