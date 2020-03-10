package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class VisualIndicator2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visual_indicator2)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainlayout = findViewById<LinearLayout>(R.id.visualIndicator2Layout)

        mainlayout.addView(firstTitle(this))
        for (j in (0..9)){
            mainlayout.addView(baseAsset(this))
        }

    }

    fun firstTitle(context: Context, height: Int = 150, text: String = "ALL"): LinearLayout{
        val layout = LinearLayout(context)
        layout.setBackgroundResource(R.color.white)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height)
        params.gravity = Gravity.CENTER_VERTICAL
        params.weight = 1f

        val subparams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        subparams.gravity = Gravity.CENTER_VERTICAL

        layout.layoutParams = params

        val textView = TextView(context)
        textView.text = text
        textView.textSize = 20f
        textView.setTextColor(Color.BLACK)
        textView.gravity = Gravity.CENTER_VERTICAL
        textView.layoutParams = params

        val numberView = TextView(context)
        numberView.text = randomData()
        numberView.textSize = 20f
        numberView.setTextColor(Color.BLACK)
        numberView.layoutParams = subparams

        val detailView = TextView(context)
        detailView.text = ">"
        detailView.textSize = 26f
        detailView.setTextColor(Color.BLACK)
        detailView.layoutParams = subparams
        detailView.gravity = Gravity.CENTER_VERTICAL
        detailView.setPadding(20,0,0,0)

        layout.addView(textView)
        layout.addView(numberView)
        layout.addView(detailView)

        return layout
    }

    fun baseAsset(context: Context): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180)
        params.gravity = Gravity.CENTER_VERTICAL

        val layout = LinearLayout(context)
        layout.setPadding(0,2,0,0)
        layout.layoutParams = params
        layout.orientation = LinearLayout.VERTICAL

        layout.addView(firstTitle(this, 70))
        layout.addView(getSecondLayout(this))

        return layout
    }

    fun getSecondLayout(context: Context, height: Int = 80): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height)
        params.gravity = Gravity.CENTER_VERTICAL

        val layout = LinearLayout(context)
        layout.setBackgroundResource(R.color.white)
        layout.layoutParams = params

        val imgparams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(60, 60)
        imgparams.topMargin = 10
        imgparams.bottomMargin = 10
        imgparams.gravity = Gravity.CENTER_VERTICAL
        imgparams.leftMargin = 20
        imgparams.rightMargin = 20

        val textViewparams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
        imgparams.gravity = Gravity.CENTER_VERTICAL

        val img = ImageView(context)
        img.layoutParams = imgparams
        Glide.with(this).load(R.drawable.setting).into(img)

        val textView1 = TextView(context)
        textView1.text = randomData()
        textView1.setTextColor(Color.BLACK)
        textView1.gravity = Gravity.CENTER_VERTICAL
        textView1.layoutParams = textViewparams

        val textView2 = TextView(context)
        textView2.text = randomData()
        textView2.setTextColor(Color.BLACK)
        textView2.gravity = Gravity.CENTER_VERTICAL
        textView2.layoutParams = textViewparams

        layout.addView(img)
        layout.addView(textView1)
        layout.addView(getBarchart(this))
        layout.addView(textView2)

        return layout
    }

    fun getBarchart(context: Context): ColumnChartView{
        val barchart = ColumnChartView(context)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(700, 100)
        barchart.layoutParams = params

        val column: MutableList<Column> = arrayListOf<Column>()

        for(i in (0..3)) {
            column.add(Column(arrayListOf(SubcolumnValue(Random.nextInt(20) * 1f, getColor(R.color.orangeBackground)))))
        }

        val data = ColumnChartData(column)
        barchart.columnChartData = data

        return barchart
    }

    fun randomData(): String{
        return (Random.nextInt(2000) + 100).toString()
    }
}
