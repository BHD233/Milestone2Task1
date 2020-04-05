package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure8_5 : AppCompatActivity() {
    val strSrc = arrayOf("Facebook", "Twitter", "Contacts")
    val imgSrc = arrayOf(R.drawable.i, R.drawable.b, R.drawable.d)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure8_5)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure8_5_main_layout)

        for (i in (0..strSrc.size - 1)){
            mainLayout.addView(getBaseAsset())
            index++
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure8_5_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure8_5_text1)
        text1.text = strSrc[index]

        val text2 = asset.findViewById<TextView>(R.id.figure8_5_text2)
        text2.text = text2.text.toString() + strSrc[index]

        val img = asset.findViewById<ImageView>(R.id.figure8_5_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        return asset
    }
}