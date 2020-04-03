package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure7_25 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.c, R.drawable.b, R.drawable.d, R.drawable.e)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure7_25)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure7_25_main_layout)

        val random = randomInt(2) + 2

        for (i in (0..random)){
            mainLayout.addView(getBaseAsset(false))
            index = i % imgSrc.size
        }

        for (i in (random..6)){
            mainLayout.addView(getBaseAsset(true))
            index = i % imgSrc.size
        }

        getChart()
    }

    fun getChart() {
        val chart = findViewById<LinearLayout>(R.id.figure7_25_progress_bar)
        var width = 900
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(randomInt(width), LinearLayout.LayoutParams.MATCH_PARENT)

        val a = LinearLayout(this)
        a.setBackgroundResource(R.color.green)
        a.layoutParams = params
        chart.addView(a)
    }

    fun getBaseAsset(isHaveLine: Boolean): View {
        val asset = layoutInflater.inflate(R.layout.figure7_25_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure7_25_text)
        text1.text = randomText(10)

        val line = asset.findViewById<TextView>(R.id.figure7_25_line)
        val doneImg = asset.findViewById<ImageView>(R.id.figure7_25_done)
        Glide.with(this).load(imgSrc[index]).into(doneImg)


        if (isHaveLine) {
            line.visibility = TextView.VISIBLE
        } else {
            line.visibility = TextView.INVISIBLE
        }

        return asset
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length - 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }
}
