package com.bhd.milestone2task1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import kotlin.random.Random

class Figure11_32 : AppCompatActivity() {
    val colorSource = arrayOf(R.color.red, R.color.blueBackground, R.color.green, R.color.yellow, R.color.purple,
                                R.color.grey, R.color.orangeBackground)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure11_32)

        getChart()
    }

    fun getChart(){
        val pieChart = findViewById<PieChartView>(R.id.figure11_32_chart)

        val value: MutableList<Float> = arrayListOf()
        val sliceValue: MutableList<SliceValue> = arrayListOf()
        var total: Float = 0f
        for (i in 0..colorSource.size - 1){
            if (i == colorSource.size){
                value.add(100 - total)
            } else {
                val va = randomInt(100 / colorSource.size).toFloat()
                value.add(va)
                total += va
            }

            sliceValue.add(SliceValue(value[i], getColor(colorSource[i])))
        }

        val pieData = PieChartData(sliceValue)

        pieData.setHasLabels(true)

        pieChart.pieChartData = pieData
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }
}