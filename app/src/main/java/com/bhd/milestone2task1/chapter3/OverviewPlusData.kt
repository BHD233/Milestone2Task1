package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class OverviewPlusData : AppCompatActivity() {

    val value: MutableList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview_plus_data)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val space = 10

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = space
        params.bottomMargin = space
        params.weight = 1f
        params.gravity = Gravity.CENTER_VERTICAL

        val imgparams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(100, 100)
        imgparams.topMargin = space
        imgparams.bottomMargin = space
        imgparams.gravity = Gravity.CENTER_VERTICAL
        imgparams.leftMargin = 20
        imgparams.rightMargin = 20

        val mainLayout = findViewById<LinearLayout>(R.id.overview_plus_data_layout)

        //month
        val textView = TextView(this)
        textView.text = "December 2019"
        textView.textSize = 28f
        params.leftMargin = 30
        textView.layoutParams = params
        mainLayout.addView(textView)

        params.leftMargin = 0

        for (i in (0..7)){
            val curlayout = LinearLayout(this)
            curlayout.layoutParams = params

            val img = ImageView(this)
            img.layoutParams = imgparams
            Glide.with(this).load(R.drawable.c).into(img)
            curlayout.addView(img)

            curlayout.addView(getTitleDate(this, params))

            val heartRate = TextView(this)
            heartRate.text = randomData(98)
            heartRate.textSize = 40f
            heartRate.gravity = Gravity.CENTER_VERTICAL
            curlayout.addView(heartRate)

            curlayout.addView(getHeart(this))

            mainLayout.addView(curlayout)
        }

        getBarchart()
    }

    fun getBarchart(){
        val barchart = findViewById<ColumnChartView>(R.id.barchart)
        val column: MutableList<Column> = arrayListOf<Column>()

        for(i in (0..value.size - 1)) {
            column.add(Column(arrayListOf(SubcolumnValue(value[i] * 1f, Color.RED))))
        }

        val data = ColumnChartData(column)
        barchart.columnChartData = data
    }

    fun getHeart(context: Context): LinearLayout{
        val sublayout = LinearLayout(context)
        sublayout.orientation = LinearLayout.VERTICAL

        val imgparams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(80, 80)
        imgparams.topMargin = 15
        imgparams.bottomMargin = 15
        imgparams.gravity = Gravity.CENTER_VERTICAL
        imgparams.leftMargin = 20
        imgparams.rightMargin = 20

        val img = ImageView(this)
        img.layoutParams = imgparams
        Glide.with(this).load(R.drawable.heart).into(img)
        sublayout.addView(img)

        val heartRate = TextView(this)
        heartRate.text = "BPM"
        heartRate.textSize = 20f
        heartRate.gravity = Gravity.CENTER_VERTICAL
        sublayout.addView(heartRate)

        return sublayout
    }

    fun getTitleDate(context: Context, params: LinearLayout.LayoutParams): LinearLayout{
        val sublayout = LinearLayout(context)
        sublayout.layoutParams = params
        sublayout.orientation = LinearLayout.VERTICAL

        val title = TextView(context)
        title.text = randomData()
        title.textSize = 30f

        val date = TextView(context)
        date.text = randomData()
        date.textSize = 24f
        date.setTextColor(getColor(R.color.blueBackground))

        sublayout.addView(title)
        sublayout.addView(date)

        return sublayout
    }

    fun randomData(bound: Int = 2000): String{
        val a = Random.nextInt(bound)
        if (bound < 2000){
            value.add(a)
        }
        return (a.toString())
    }
}
