package com.bhd.milestone2task1

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class Figure6_19 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_19)

        getAsset(this)
    }
    fun getAsset(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_19_main_layout)

        for(i in 0..6) {
            val asset = layoutInflater.inflate(R.layout.figure6_19_asset1, null)

            val text1 = asset.findViewById<TextView>(R.id.figure6_19_text1)
            text1.text = randomText(10)

            val layout = asset.findViewById<LinearLayout>(R.id.figure6_19_asset_main_layout)

            for (i in (0..Random.nextInt(2))) {
                val asset2 = layoutInflater.inflate(R.layout.figure6_19_asset2, null)

                val text2 = asset2.findViewById<TextView>(R.id.figure6_19_text2)
                text2.text = randomText(3).toUpperCase()

                val text4 = asset2.findViewById<TextView>(R.id.figure6_19_text4)
                text4.text = randomInt()

                layout.addView(asset2)
            }

            mainLayout.addView(asset)
        }
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }

    fun randomInt(max: Int = 200): String{
        return (Random.nextInt(max) + 10).toString()
    }
}
