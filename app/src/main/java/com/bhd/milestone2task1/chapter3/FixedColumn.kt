package com.bhd.milestone2task1

import android.content.Context
import android.os.Bundle
import android.view.ViewTreeObserver.OnScrollChangedListener
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class FixedColumn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fixed_column)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val space = 15

        val leftColumn = findViewById<LinearLayout>(R.id.fixedColumnLeft)
        val column1 = findViewById<LinearLayout>(R.id.column1Layout)
        val column2 = findViewById<LinearLayout>(R.id.column2Layout)
        val column3 = findViewById<LinearLayout>(R.id.column3Layout)
        val column4 = findViewById<LinearLayout>(R.id.column4Layout)
        val column5 = findViewById<LinearLayout>(R.id.column5Layout)

        val layoutArray = arrayOf(leftColumn, column1, column2, column3, column4, column5)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = space
        params.bottomMargin = space
        params.leftMargin = space

        for (i in (0..19)){
            for (j in (0..layoutArray.size - 1)){
                val departView = TextView(context)
                departView.text = randomData()
                departView.textSize = 24f
                departView.setTextColor(getColor(R.color.black))
                departView.layoutParams = params
                departView.setPadding(0,space,0,space)

                layoutArray[j].addView(departView)
            }
        }

        val scrollView1 = findViewById<HorizontalScrollView>(R.id.horizontalScrollView1)
        val scrollView2 = findViewById<HorizontalScrollView>(R.id.horizontalScrollView2)

        scrollView2.getViewTreeObserver()
            .addOnScrollChangedListener(OnScrollChangedListener {
                val scrollX: Int = scrollView2.getScrollX()
                scrollView1.scrollX = scrollX
            })
    }

    fun randomData(): String{
        return (Random.nextInt(2000) + 100).toString()
    }
}
