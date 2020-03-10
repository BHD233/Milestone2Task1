package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import lecho.lib.hellocharts.model.Line
import kotlin.random.Random

class GroupedRows : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grouped_rows)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainlayout = findViewById<LinearLayout>(R.id.groupedRowsLayout)
        //all account
        mainlayout.addView(baseAsset("All accounts","All transactions", "", "$2546", this, getColor(R.color.greenLight)))

        //detail
        for (i in (0..2)){
            mainlayout.addView(mainTitleAsset(randomData(),this))

            for (j in (0..3)){
                mainlayout.addView(baseAsset(randomData(), randomData(), randomData() + " second ago", "$" + randomData(), this))
            }
        }

    }

    fun baseAsset(title: String, detail: String, time: String, money: String, context: Context, titleColor: Int = Color.BLACK): LinearLayout{
        val layout = LinearLayout(context)
        layout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val layoutParam = layout.layoutParams as LinearLayout.LayoutParams
        layout.setPadding(0,10,10,10)
        layout.setBackgroundResource(R.color.white)
        layoutParam.topMargin = 2
        layout.layoutParams = layoutParam

        val titleAndDetailLayout = LinearLayout(context)
        titleAndDetailLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        titleAndDetailLayout.orientation = LinearLayout.VERTICAL
        val param = titleAndDetailLayout.layoutParams as LinearLayout.LayoutParams
        param.weight = 1f
        titleAndDetailLayout.layoutParams = param

        val moneyAndTimeLayout = LinearLayout(context)
        moneyAndTimeLayout.orientation = LinearLayout.VERTICAL


        val titleView = TextView(context)
        titleView.text = title
        titleView.setTypeface(null, Typeface.BOLD)
        titleView.textSize = 24f
        titleView.setTextColor(titleColor)

        val detailView = TextView(context)
        detailView.text = detail
        detailView.textSize = 22f

        titleAndDetailLayout.addView(titleView)
        titleAndDetailLayout.addView(detailView)

        val moneyView = TextView(context)
        moneyView.text = money
        moneyView.gravity = Gravity.RIGHT
        moneyView.setTypeface(null, Typeface.BOLD)
        moneyView.textSize = 24f
        moneyView.setTextColor(getColor(R.color.greenLight))

        val timeView = TextView(context)
        timeView.text = time
        timeView.textSize = 22f

        moneyAndTimeLayout.addView(moneyView)
        moneyAndTimeLayout.addView(timeView)

        layout.addView(titleAndDetailLayout)
        layout.addView(moneyAndTimeLayout)

        return layout
    }

    fun mainTitleAsset(title: String, context: Context): LinearLayout{
        val layout = LinearLayout(context)
        layout.setBackgroundResource(R.color.blueLight)

        val titleView = TextView(context)
        titleView.gravity = Gravity.CENTER_HORIZONTAL
        val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        titleView.layoutParams = param
        titleView.text = title
        titleView.setTextColor(getColor(R.color.blueBackground))
        titleView.textSize = 24f

        layout.addView(titleView)

        return layout
    }

    fun randomData(): String{
        return (Random.nextInt(2000) + 100).toString()
    }
}
