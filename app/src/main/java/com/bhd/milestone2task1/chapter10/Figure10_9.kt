package com.bhd.milestone2task1

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure10_9 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.c, R.drawable.b, R.drawable.d, R.drawable.e, R.drawable.f)
    var index = 0
    var width = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure10_9)

        var displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure10_9_sub_layout)

        for (i in (0..imgSrc.size - 1)){
            index = i
            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure10_9_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure10_9_text)
        text1.text = randomText(4)

        if (randomInt() % 2 == 0){
            val text2 = asset.findViewById<TextView>(R.id.figure10_9_num)
            text2.text = (randomInt(10) + 1).toString()
        } else {
            val layout = asset.findViewById<LinearLayout>(R.id.figure10_9_alert)
            layout.visibility = LinearLayout.GONE
        }

        val img = asset.findViewById<ImageView>(R.id.figure10_9_img)

        val params = img.layoutParams
        params.width = width / imgSrc.size
        img.layoutParams = params

        Glide.with(this).load(imgSrc[index]).into(img)

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