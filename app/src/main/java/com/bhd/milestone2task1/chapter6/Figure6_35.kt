package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure6_35 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.user)
    val color = arrayOf(R.color.blueBackground, R.color.greenLight, R.color.orangeBackground, R.color.red, R.color.pinkBackground,
        R.color.grey)
    var index = 0

    var width: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_35)

        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_35_main_layout)

        mainLayout.measure(0, 0)
        width = mainLayout.measuredWidth

       for (j in (0..imgSrc.size - 1)){
            mainLayout.addView(getBaseAsset(this))
            index++
        }
    }


    fun getBaseAsset(context: Context): View {

        val asset = layoutInflater.inflate(R.layout.figure6_35_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure6_35_text1)
        text1.text = randomText(10)

        val text2 = asset.findViewById<TextView>(R.id.figure6_35_text2)
        text2.text = randomInt(2000).toString()

        val img = asset.findViewById<ImageView>(R.id.figure6_35_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        val chart = asset.findViewById<LinearLayout>(R.id.figure6_35_chart)
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(randomInt(width),50)

        val a = LinearLayout(this)
        a.setBackgroundResource(color[index % color.size])
        a.layoutParams = params
        chart.addView(a)
        return asset
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

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max) + 10)
    }
}
