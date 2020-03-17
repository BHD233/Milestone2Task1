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


class Figure4_33 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure4_33)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure4_33_main_layout)

        for (j in (0..6)){
            mainLayout.addView(getBaseAsset(this))
        }

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250)
        params.topMargin = 1
        params.bottomMargin = 1

        val loadMoreLayout = LinearLayout(this)
        loadMoreLayout.layoutParams = params
        loadMoreLayout.gravity = Gravity.CENTER_VERTICAL
        loadMoreLayout.orientation = LinearLayout.VERTICAL
        loadMoreLayout.setBackgroundResource(R.color.white)

        val textView1 = TextView(this)
        textView1.text = "Load More Items"
        textView1.textSize = 22f
        textView1.setTextColor(getColor(R.color.blueDark))

        val textView2 = TextView(this)
        textView2.text = "566 items total"
        textView2.textSize = 20f
        textView2.setTextColor(Color.BLACK)

        loadMoreLayout.addView(textView1)
        loadMoreLayout.addView(textView2)

        mainLayout.addView(loadMoreLayout)
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

        val asset = layoutInflater.inflate(R.layout.figure4_33_asset, null)
        asset.layoutParams = params
        val img = asset.findViewById<ImageView>(R.id.figure4_33_img)
        Glide.with(this).load(R.drawable.a).into(img)

        val text = asset.findViewById<TextView>(R.id.figure4_33_text)
        text.text = randomText(40)
        text.setTextColor(Color.BLACK)

        val price = asset.findViewById<TextView>(R.id.figure4_33_price)
        price.text = "$" + randomInt()

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
