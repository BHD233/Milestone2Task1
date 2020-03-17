package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import lecho.lib.hellocharts.model.Line
import org.w3c.dom.Text
import kotlin.random.Random


class Figure4_24 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure4_24)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure4_24_main_layout)
        mainLayout.measure(0, 0)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = 40
        params.leftMargin = 30
        params.rightMargin = 30

        val textViewParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        textViewParams.leftMargin = 40

        val maxWidth = mainLayout.measuredWidth

        var subLayout = LinearLayout(context)
        subLayout.layoutParams = params
        subLayout.orientation = LinearLayout.HORIZONTAL

        var curWidth = 20
        val space = 10

        for (j in (0..6)){
            val textView1 = TextView(this)
            textView1.text = randomText(Random.nextInt(10) + 5)
            textView1.textSize = 24f
            textView1.setPadding(space, space, space, space)
            textView1.setTextColor(getColor(R.color.blueBackground))
            textView1.setBackgroundResource(R.color.white)
            textView1.layoutParams = textViewParams

            if (curWidth + textView1.width + space + 20 > maxWidth){
                mainLayout.addView(subLayout)

                subLayout = LinearLayout(context)
                subLayout.layoutParams = params
                subLayout.orientation = LinearLayout.HORIZONTAL

                curWidth = 20
            }

            subLayout.addView(textView1)
            textView1.measure(0, 0)
            curWidth += textView1.measuredWidth + space
        }

        //add last
        mainLayout.addView(subLayout)
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
}
