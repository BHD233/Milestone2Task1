package com.bhd.milestone2task1

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import lecho.lib.hellocharts.model.Line
import kotlin.random.Random


class Figure4_3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure4_3)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure4_3_main_layout)

        for (j in (0..6)){
           mainLayout.addView(getBaseAsset(this))
        }
    }

    fun getBaseAsset(context: Context): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = 1
        params.bottomMargin = 1

        val layout = LinearLayout(context)
        layout.layoutParams = params
        layout.orientation = LinearLayout.HORIZONTAL
        layout.setBackgroundResource(R.color.white)

        layout.addView(textLayout(context))
        layout.addView((imgLayout(context)))

        return layout
    }

    fun imgLayout(context: Context): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.rightMargin = 30
        params.gravity = Gravity.CENTER_VERTICAL

        val imgParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(80, 80)

        val layout = LinearLayout(context)
        layout.layoutParams = params
        layout.orientation = LinearLayout.VERTICAL

        val img = ImageView(context)
        img.layoutParams = imgParams
        Glide.with(this).load(R.drawable.heart).into(img)


        val textView = TextView(context)
        textView.text = randomData()

        layout.addView(img)
        layout.addView(textView)

        return layout
    }

    fun textLayout(context: Context): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.weight = 1f
        params.leftMargin = 30
        params.topMargin = 50
        params.bottomMargin = 50

        val layout = LinearLayout(context)
        layout.layoutParams = params
        layout.orientation = LinearLayout.VERTICAL

        val textView = TextView(context)
        textView.text = randomData()
        textView.textSize = 30f
        textView.setTextColor(Color.BLACK)

        val subLayout = LinearLayout(context)
        subLayout.orientation = LinearLayout.HORIZONTAL

        val textView1 = TextView(context)
        textView1.text = randomData()
        textView1.setTextColor(Color.BLUE)

        val textView2 = TextView(context)
        textView2.text = randomData()

        subLayout.addView(textView1)
        subLayout.addView(textView2)

        layout.addView(textView)
        layout.addView(subLayout)

        return layout
    }

    fun randomData(): String{
        return (Random.nextInt(2000) + 100).toString()
    }
}
