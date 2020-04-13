package com.bhd.milestone2task1

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class Figure9_28 : AppCompatActivity() {

    var data: ArrayList<String> = arrayListOf()
    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure9_28)

        data = getData()

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure9_28_main_layout)

        var cur = '@'
        for (i in (0..data.size - 1)){
            index = i

            if (data[i][0] != cur){
                cur = data[i][0]
                mainLayout.addView(getTextView(this))
            }

            mainLayout.addView(getBaseAsset())
        }
    }

    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.figure9_28_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.figure9_28_text)
        text1.text = data[index]

        return asset
    }

    fun getTextView(context: Context): View{
        val textView = TextView(context)
        textView.text = data[index][0].toString()
        textView.setTextColor(getColor(R.color.bluequietLight))
        textView.textSize = 30f

        return textView
    }


    fun getData(size: Int = 20): ArrayList<String> {
        var result: MutableList<String> = arrayListOf<String>()

        for (i in 0..size - 1) {
            result.add(randomText())
        }

        result.sort()

        return result as ArrayList<String>
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length + 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }
}