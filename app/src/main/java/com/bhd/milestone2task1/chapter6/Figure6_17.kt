package com.bhd.milestone2task1

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure6_17 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.user)

    var index = 0

    var width = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_17)

        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_17_main_layout)

        width = 50

        for (j in (0..imgSrc.size - 1)){
            mainLayout.addView(getBaseAsset(this))
            index++
        }
    }


    fun getBaseAsset(context: Context): View {
        val asset = layoutInflater.inflate(R.layout.figure6_17_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure6_17_text)
        text1.text = randomText(3)

        val img = asset.findViewById<ImageView>(R.id.figure6_17_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        val chart = asset.findViewById<LinearLayout>(R.id.figure6_17_asset_layout)

        val textParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        textParams.gravity = Gravity.CENTER_VERTICAL

        val textParams2: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        textParams2.gravity = Gravity.CENTER_VERTICAL

        val assetText1 = TextView(this)
        var randomResult = randomInt(30)
        assetText1.text = (randomResult + 20).toString()
        assetText1.textSize = 30f
        textParams.leftMargin = 20 + randomResult * 4
        assetText1.layoutParams = textParams

        val range = randomInt(width) + 100
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(range,60)
        params.gravity = Gravity.CENTER_VERTICAL

        val a = LinearLayout(this)
        a.setBackgroundResource(R.drawable.rounded_corner_blackdarkback)
        params.leftMargin = 20
        a.layoutParams = params

        val assetText2 = TextView(this)
        assetText2.text = (randomResult + 20 + range / 10).toString()
        assetText2.textSize = 30f
        textParams2.leftMargin = 20
        assetText2.layoutParams = textParams2



        chart.addView(assetText1)
        chart.addView(a)
        chart.addView(assetText2)

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
        return (Random.nextInt(max) + 10)
    }
}
