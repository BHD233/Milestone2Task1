package com.bhd.milestone2task1

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure9_14 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure9_14)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure9_14_main_layout)

        for (i in (0..1)){
            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure9_14_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure9_14_author)
        text1.text = randomText(15)

        val text2 = asset.findViewById<TextView>(R.id.figure9_14_publisher)
        text2.text = randomText(5)

        val text3 = asset.findViewById<TextView>(R.id.figure9_14_text)
        text3.text = randomText(10)

        val text4 = asset.findViewById<TextView>(R.id.figure9_14_time)
        text4.text = randomText(10)

        val img = asset.findViewById<ImageView>(R.id.figure9_14_img)
        Glide.with(this).load(R.drawable.g).into(img)

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