package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class Figure6_34 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_34)

        getAsset(this)
    }


    fun getAsset(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_34_main_layout)

        for(i in 0..6) {
            val asset = layoutInflater.inflate(R.layout.figure_6_34_asset, null)

            val barChart = asset.findViewById<ColumnChartView>(R.id.figure6_34_chart)
            val column: MutableList<Column> = arrayListOf<Column>()
            for (i in(0..6)) {
                column.add(
                    Column(
                        arrayListOf(
                            SubcolumnValue(Random.nextInt(10) * 1f, getColor(R.color.green)),
                                    SubcolumnValue(Random.nextInt(10) * 1f, getColor(R.color.greenLight))
                        )
                    )
                )
            }
            val data = ColumnChartData(column)
            data.setStacked(true)
            barChart.columnChartData = data

            val text1 = asset.findViewById<TextView>(R.id.figure6_34_text1)
            text1.text = randomText(5)

            val text2 = asset.findViewById<TextView>(R.id.figure6_34_text2)
            text2.text = randomInt()

            val text3 = asset.findViewById<TextView>(R.id.figure6_34_text3)
            text3.text = randomInt()

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
