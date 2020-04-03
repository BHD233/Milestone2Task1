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

class Figure7_23 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure7_23)
        getInterface()
    }


    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure7_23_main_layout)

        for (j in (0..imgSrc.size - 1)){
            mainLayout.addView(getBaseAsset())
            index++
        }
    }


    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure7_23_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure7_23_text)
        text1.text = randomText(40)

        val img = asset.findViewById<ImageView>(R.id.figure7_23_img)
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
