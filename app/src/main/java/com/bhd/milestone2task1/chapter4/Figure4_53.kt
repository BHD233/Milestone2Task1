package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import lecho.lib.hellocharts.model.Line
import org.w3c.dom.Text
import kotlin.random.Random


class Figure4_53 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firgure4_53)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure4_53_main_layout)

        for (j in (0..imgSrc.size - 1)){
            mainLayout.addView(getBaseAsset(this))
            index++
        }
    }

    fun getBaseAsset(context: Context): LinearLayout{
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = 1
        params.bottomMargin = 1

        val layout = LinearLayout(context)
        layout.layoutParams = params
        layout.orientation = LinearLayout.HORIZONTAL
        layout.setBackgroundResource(R.color.white)

        val asset = layoutInflater.inflate(R.layout.figure4_53_asset, null)
        asset.layoutParams = params

        val img = asset.findViewById<ImageView>(R.id.figure4_53_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        val text = asset.findViewById<TextView>(R.id.figure4_53_text1)
        text.text = randomText(20)
        text.setTextColor(Color.BLACK)

        val text2 = asset.findViewById<TextView>(R.id.figure4_53_text2)
        text2.text = randomText(20)

        val text3 = asset.findViewById<TextView>(R.id.figure4_53_text2)
        if (Random.nextInt() % 2 == 0){
            text3.text = "Installed"
        } else {
            text3.text = "Update"
        }

        layout.addView(asset)

        return layout
    }

    fun randomInt(): String{
        return (Random.nextInt(200) + 100).toString()
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
