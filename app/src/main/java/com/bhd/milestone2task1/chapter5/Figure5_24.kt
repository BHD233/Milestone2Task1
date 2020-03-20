package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide

class Figure5_24 : AppCompatActivity() {
    var showPopupWindow: Boolean = false
    lateinit var popupWindow: PopupWindow
    var popupHeight = 0
    lateinit var blurBackground: PopupWindow
    lateinit var parentLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure5_24)

        val popupLayout = layoutInflater.inflate(R.layout.figure5_24_popup_menu, null)
        popupLayout.measure(0, 0)
        popupHeight = popupLayout.measuredHeight

        val bottom = findViewById<LinearLayout>(R.id.figure5_24_bottom)
        bottom.measure(0,0)
        popupHeight += bottom.measuredHeight

        parentLayout = findViewById(R.id.figure5_24_parent_layout)

        popupWindow = PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        getAsset(this)
    }

    fun getAsset(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure5_24_main_layout)

        for(i in 0..6) {
            val asset = layoutInflater.inflate(R.layout.figure5_24_asset, null)
            mainLayout.addView(asset)
        }
    }

    fun onToggleButtonClicked(view: View){
        if (!showPopupWindow) {
            popupWindow.showAsDropDown(view, 0, -popupHeight, Gravity.BOTTOM)
            parentLayout.setBackgroundResource(R.color.shelfStage1)
            showPopupWindow = true
        } else{
            popupWindow.dismiss()
            parentLayout.setBackgroundResource(R.color.white)
            showPopupWindow = false
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        popupWindow.dismiss()
        showPopupWindow = false
        return true
    }
}