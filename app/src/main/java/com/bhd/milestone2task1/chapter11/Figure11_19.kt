package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure11_19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure11_19)

        getInterface()
    }

    fun getInterface(){
        var mainLayout = findViewById<LinearLayout>(R.id.figure11_19_main_layout)

        var a = randomInt(2) + 5

        for (i in (0..a)){
            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure11_19_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure11_19_text)
        text1.text = randomText(randomInt(30) + 45)

        val text2 = asset.findViewById<TextView>(R.id.figure11_19_userName)
        text2.text = randomText(randomInt(5) + 3)

        val text3 = asset.findViewById<TextView>(R.id.figure11_19_realName)
        text3.text = randomText(randomInt(5) + 4)

        val text4 = asset.findViewById<TextView>(R.id.figure11_19_time)
        text4.text = (randomInt(10) + 1).toString() + "d"

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