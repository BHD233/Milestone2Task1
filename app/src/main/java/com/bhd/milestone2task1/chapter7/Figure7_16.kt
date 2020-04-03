package com.bhd.milestone2task1

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

class Figure7_16 : AppCompatActivity() {
    var showPopupWindow: Boolean = false
    lateinit var popupWindow: PopupWindow

    lateinit var textView: View
    var isInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure7_16)

        val popupLayout = layoutInflater.inflate(R.layout.figure7_16_float_menu, null)

        popupWindow = PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        getInterface()
    }


    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure7_16_main_layout)

        for (j in (0..5)){
            mainLayout.addView(getBaseAsset())
        }
    }

    fun onToggleDropButtonClicked(view: View){
        if (!showPopupWindow) {
            popupWindow.showAsDropDown(textView, 0,-50, Gravity.CENTER_HORIZONTAL)
            showPopupWindow = true
        } else{
            popupWindow.dismiss()
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure7_16_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure7_16_text)
        text1.text = randomText(2)

        if (!isInit){
            textView = asset
            isInit = true
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
}
