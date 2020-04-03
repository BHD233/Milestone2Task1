package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure7_4 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.q3, R.drawable.q6, R.drawable.q8, R.drawable.q9)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure7_4)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure7_4_main_layout)

        for (i in (0..imgSrc.size - 1)){
            mainLayout.addView(getBaseAsset())
            index++
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure7_4_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure7_4_title)
        text1.text = randomText(10)

        val text2 = asset.findViewById<TextView>(R.id.figure7_4_text)
        text2.text = randomText(30)

        val img = asset.findViewById<ImageView>(R.id.figure7_4_img)
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
}
