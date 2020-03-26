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

class Figure6_20 : AppCompatActivity() {

    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_20)
        getAsset(this)
        getChart()
    }

    fun getAsset(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_20_main_layout)

        for(i in 0..20) {
            val asset = layoutInflater.inflate(R.layout.figure6_20_asset, null)

            val text1 = asset.findViewById<TextView>(R.id.figure6_20_text1)
            text1.text = randomText(10)

            val text2 = asset.findViewById<TextView>(R.id.figure6_20_text2)
            text2.text = randomInt(2000)

            val text3 = asset.findViewById<TextView>(R.id.figure6_20_text3)
            text3.text = randomInt(2000)

            val layout = asset.findViewById<LinearLayout>(R.id.figure6_20_asset_layout)
            if (index % 2 == 0){
                layout.setBackgroundResource(R.color.shelfStage4)
            }

            mainLayout.addView(asset)

            index++
        }
    }

    fun getChart(){
        val barChart = findViewById<ColumnChartView>(R.id.figure6_20_chart)
        val column: MutableList<Column> = arrayListOf<Column>()
        for (i in(0..19)) {
            column.add(
                Column(
                    arrayListOf(
                        SubcolumnValue(Random.nextInt(100) * 1f, getColor(R.color.green)),
                        SubcolumnValue(Random.nextInt(100) * 1f, getColor(R.color.greenLight))
                    )
                )
            )
        }
        val data = ColumnChartData(column)
        data.setStacked(true)
        barChart.columnChartData = data
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
