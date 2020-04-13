package com.bhd.milestone2task1

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure9_12 : AppCompatActivity() {
    var showPopupWindow: Boolean = false
    lateinit var popupWindow: PopupWindow

    lateinit var layout: View

    val imgSrc = arrayOf(R.drawable.c, R.drawable.b, R.drawable.d, R.drawable.e)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure9_12)

        val popupLayout = layoutInflater.inflate(R.layout.figure9_12_alert, null)
        popupWindow = PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure9_12_main_layout)

        layout = mainLayout

        for (i in (0..6)){
            mainLayout.addView(getBaseAsset())
            index = i % imgSrc.size
        }
    }

    fun showPopUp(view: View){
        if (!showPopupWindow) {
            popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0 ,0)
            showPopupWindow = true
        } else{
            popupWindow.dismiss()
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure9_12_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure9_12_title)
        text1.text = randomText(15)

        val text2 = asset.findViewById<TextView>(R.id.figure9_12_who_sent)
        text2.text = randomText(5)

        val text3 = asset.findViewById<TextView>(R.id.figure9_12_time)
        text3.text = randomInt(10).toString() + "PM"

        val img = asset.findViewById<ImageView>(R.id.figure9_12_avatar)
        Glide.with(this).load(imgSrc[index]).into(img)

        val status = asset.findViewById<LinearLayout>(R.id.figure9_12_status)
        val draw = status.background

        if(randomInt(100) % 2 == 1){
            draw.setTint(Color.GRAY)
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

    fun randomInt(bound: Int): Int{
        return (Random.nextInt(bound))
    }
}