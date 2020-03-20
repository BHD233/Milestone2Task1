package com.bhd.milestone2task1

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.*
import android.widget.*
import androidx.annotation.ContentView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import java.nio.channels.GatheringByteChannel
import java.util.*
import java.util.zip.Inflater

class ToggleMenu : AppCompatActivity() {
    var showPopupWindow: Boolean = false
    lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toggle_menu)

        var toolbar: Toolbar = findViewById(R.id.toggleToolbar)
        setSupportActionBar(toolbar)

        val popupLayout = layoutInflater.inflate(R.layout.toggle_popup, null)

        popupWindow = PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

    }

    fun onToggleDropButtonClicked(view: View){
        if (!showPopupWindow) {
            popupWindow.showAsDropDown(view)
            showPopupWindow = true
        } else{
            popupWindow.dismiss()
            showPopupWindow = false
        }
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i)

        for (i in 0..8){
            val titleRadom = Random().nextInt(200).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        popupWindow.dismiss()
        showPopupWindow = false
        return true
    }
}