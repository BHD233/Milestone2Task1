package com.bhd.milestone2task1

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.figure10_13.*
import kotlin.random.Random

class Figure10_13 : AppCompatActivity() {
    val imgSrc = arrayOf(R.drawable.q6, R.drawable.q9, R.drawable.q4)
    var index = 0
    var curX = 0
    var width = 0

    lateinit var scrollView: HorizontalScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure10_13)

        scrollView = findViewById(R.id.figure10_13_scroll_view)

        var displayMetrics = DisplayMetrics()
        var display = windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels

        getInterface()
    }

    fun getInterface(){
        var mainLayout = findViewById<LinearLayout>(R.id.figure10_13_main_layout)

        for (i in (0..imgSrc.size - 1)){
            index = i
           mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure10_13_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure10_13_text1)
        text1.text = randomText(randomInt(10) + 5)

        val text2 = asset.findViewById<TextView>(R.id.figure10_13_text2)

        var param = text2.layoutParams
        param.width = width - text2.marginLeft - text2.marginRight

        text2.layoutParams = param
        text2.text = randomText(randomInt(20) + 30)

        val img = asset.findViewById<ImageView>(R.id.figure10_13_img)
        Glide.with(this).load(imgSrc[index]).into(img)

        return asset
    }

    fun onButtonClick(view: View){
        var button = view as Button
        button.text = "Next"

        scrollView.scrollTo(curX + scrollView.right, 0)

        curX += scrollView.right
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length - 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }
}