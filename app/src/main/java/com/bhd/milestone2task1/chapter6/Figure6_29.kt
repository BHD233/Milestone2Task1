package com.bhd.milestone2task1

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class Figure6_29 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_29)

        getBaseAsset1(this)

        getBaseAsset2(this)

        getBaseAsset3()
    }

    fun getBaseAsset1(context: Context) {
        val chart = findViewById<LinearLayout>(R.id.figure6_29_progress_bar)
        var width = 900
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(randomInt(width),LinearLayout.LayoutParams.MATCH_PARENT)

        val a = LinearLayout(this)
        a.setBackgroundResource(R.color.blueBackground)
        a.layoutParams = params
        chart.addView(a)
    }

    fun getBaseAsset2(context: Context) {
        val chart = findViewById<LinearLayout>(R.id.figure6_29_box)

        val paramsBox: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(60, 60)
        paramsBox.topMargin = 2
        paramsBox.bottomMargin = 2
        val paramsLayout: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        paramsLayout.leftMargin = 2
        paramsLayout.rightMargin = 2

        for (i in (0..randomInt(4) + 5)){
            val subLayout = LinearLayout(this)
            subLayout.layoutParams = paramsLayout
            subLayout.orientation = LinearLayout.VERTICAL

            var random = randomInt(2)
            for (j in (0..1)){
                val a = LinearLayout(this)
                a.setBackgroundResource(R.color.blueBackground)
                a.layoutParams = paramsBox

                if (random == 1){
                    a.setBackgroundResource(R.color.white)
                    random = 0
                }

                subLayout.addView(a)
            }

            chart.addView(subLayout)
        }
    }

    fun getBaseAsset3(){
        val barChart = findViewById<ColumnChartView>(R.id.figure6_29_chart)
        val column: MutableList<Column> = arrayListOf<Column>()

        val random = randomInt(10)
        for (i in(0..14)) {
            var color: Int

            if (i < random){
                color = getColor(R.color.blueBackground)
            } else {
                 color = getColor(R.color.white)
            }
            column.add(
                Column(
                    arrayListOf(
                        SubcolumnValue(Random.nextInt(100) * 1f, color)
                    )
                )
            )
        }
        val data = ColumnChartData(column)
        data.setStacked(true)
        barChart.columnChartData = data
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }
}
