package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.search_form.*
import lecho.lib.hellocharts.model.Line
import org.w3c.dom.Text
import kotlin.random.Random


class Figure5_34 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.user)
    var index = 0

    val assetList: MutableList<View> = arrayListOf()

    var showPopupWindow: Boolean = false
    lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure5_34)
        getInterface(this)

        val popupLayout = layoutInflater.inflate(R.layout.figure5_34_dropdownn, null)
        popupWindow = PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure5_34_main_layout)

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

        val asset = layoutInflater.inflate(R.layout.figure5_41_asset, null)
        asset.layoutParams = params

        assetList.add(asset)

        val img = asset.findViewById<ImageView>(R.id.figure5_41_avar)
        Glide.with(this).load(imgSrc[index]).into(img)

        val img2 = asset.findViewById<ImageView>(R.id.figure5_41_icon2)
        img2.setOnClickListener{
            it->
            onToggleButtonClicked(it)
        }

        val text = asset.findViewById<TextView>(R.id.figure5_41_text)
        text.text = randomText(10)
        text.setTextColor(Color.BLACK)

        layout.addView(asset)

        return layout
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

    fun onToggleButtonClicked(view: View){
        if (!showPopupWindow) {
            popupWindow.showAsDropDown(view, 0, 70, 0)
            showPopupWindow = true
        } else{
            popupWindow.dismiss()
            showPopupWindow = false
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        popupWindow.dismiss()
        showPopupWindow = false
        return true
    }
}
