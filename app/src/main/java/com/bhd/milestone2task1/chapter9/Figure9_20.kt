package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure9_20 : AppCompatActivity() {
    val imgSrc = arrayOf( R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e)
    val color = arrayOf(R.color.blueBackground, R.color.greenLight, R.color.orangeBackground, R.color.red)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure9_20)

        getMainLayout()
    }

    fun getMainLayout(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure9_20_main_layout)
        for (i in (0..color.size - 1)) {
            index = i

            mainLayout.addView(getAsset())
        }
    }

    fun getAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure9_20_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure9_20_text)
        text1.text = randomText(10)

        val img = asset.findViewById<ImageView>(R.id.figure9_20_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        val chart = asset.findViewById<LinearLayout>(R.id.figure9_20_progressbar)

        var width = 1000
        val realwidth = randomInt(width)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(realwidth, LinearLayout.LayoutParams.MATCH_PARENT)

        val a = LinearLayout(this)
        a.setBackgroundColor(color[index])
        a.layoutParams = params
        chart.addView(a)

        val text2 = asset.findViewById<TextView>(R.id.figure9_20_percent)
        text2.text = (realwidth * 100/width).toString() + "%"


        return asset
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length + 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }
}