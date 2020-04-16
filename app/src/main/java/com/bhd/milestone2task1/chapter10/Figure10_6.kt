package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure10_6 : AppCompatActivity() {
    var index: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure10_6)

        getInterface()
    }

    fun getInterface(){
        var mainLayout = findViewById<LinearLayout>(R.id.figure10_6_main_layout)

        for (i in (1..3)){
            index = i
            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure10_6_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure10_6_text)
        text1.text = randomText(randomInt(10) + 5)

        val text2 = asset.findViewById<TextView>(R.id.figure10_6_num)
        text2.text = index.toString()

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