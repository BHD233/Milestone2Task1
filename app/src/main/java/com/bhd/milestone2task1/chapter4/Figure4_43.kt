package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import lecho.lib.hellocharts.model.Line
import org.w3c.dom.Text
import kotlin.random.Random


class Figure4_43 : AppCompatActivity() {

    val layoutList: MutableList<LinearLayout> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure4_43)
        getInterface(this)
    }

    fun getInterface(context: Context){
        val mainLayout = findViewById<LinearLayout>(R.id.figure4_43_main_layout)
        mainLayout.measure(0, 0)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = 2
        val space = 25

        for (j in (0..9)){
            val subLayout = LinearLayout(this)
            subLayout.layoutParams = params
            subLayout.setBackgroundResource(R.color.white)

            val textView1 = TextView(this)
            textView1.text = randomText(Random.nextInt(10) + 5).toUpperCase()
            textView1.textSize = 26f
            textView1.setPadding(space, space, space, space)
            textView1.setTextColor(getColor(R.color.black))

            subLayout.addView(textView1)

            subLayout.setOnClickListener {
                it->
                onButtonClicked(it)
            }

            layoutList.add(subLayout)
            mainLayout.addView(subLayout)
        }
    }

    fun onButtonClicked(view: View){
        layoutList.forEach(){
            it->
            it.setBackgroundResource(R.color.white)
        }

        val layout = view as LinearLayout
        layout.setBackgroundResource(R.color.shelfStage3)
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        alphabet.add(" ")
        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }

        var cur: String = ""
        for (i in 0..length){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }
}
