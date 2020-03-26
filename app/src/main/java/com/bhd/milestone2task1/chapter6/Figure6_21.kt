package com.bhd.milestone2task1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure6_21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_21)

        getSublayout()

        getMainLayout()
    }

    fun getSublayout(){
        val sublayout1 = findViewById<LinearLayout>(R.id.figure6_21_sublayout1)
        sublayout1.addView(getAsset1(getColor(R.color.red)))

        val sublayout2 = findViewById<LinearLayout>(R.id.figure6_21_sublayout2)
        sublayout2.addView(getAsset1(getColor(R.color.orangeBackground)))

        val sublayout3 = findViewById<LinearLayout>(R.id.figure6_21_sublayout3)
        sublayout3.addView(getAsset1(getColor(R.color.blueBackground)))
    }

    fun getMainLayout(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_21_main_layout)
        for (i in (0..10)) {
            mainLayout.addView(getAsset2())
        }
    }

    fun getAsset1(color: Int = getColor(R.color.red)): View{
        val asset = layoutInflater.inflate(R.layout.figure6_21_asset1, null)

        val text1 = asset.findViewById<TextView>(R.id.figure6_21_asset1_text1)
        text1.text = randomText(5)

        val text2 = asset.findViewById<TextView>(R.id.figure6_21_asset1_text2)
        text2.text = "$" + randomInt(2000)

        val chart = asset.findViewById<LinearLayout>(R.id.figure6_21_asset1_bar)
        var width = 200
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(randomInt(width),50)

        val a = LinearLayout(this)
        a.setBackgroundColor(color)
        a.layoutParams = params
        chart.addView(a)

        return asset
    }

    fun getAsset2(color: Int = getColor(R.color.orangeBackground)): View{
        val asset = layoutInflater.inflate(R.layout.figure6_21_asset2, null)

        val text1 = asset.findViewById<TextView>(R.id.figure6_21_asset2_text1)
        text1.text = randomText(5)

        val text2 = asset.findViewById<TextView>(R.id.figure6_21_asset2_text2)
        text2.text = "$" + randomInt(2000)

        val text3 = asset.findViewById<TextView>(R.id.figure6_21_asset2_text3)
        text2.text = "$" + randomInt(100)

        val text4 = asset.findViewById<TextView>(R.id.figure6_21_asset2_text4)
        text2.text = "$" + randomInt(2000)

        val chart = asset.findViewById<LinearLayout>(R.id.figure6_21_asset2_bar)
        var width = 400
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(randomInt(width),50)

        val a = LinearLayout(this)
        a.setBackgroundColor(color)
        a.layoutParams = params
        chart.addView(a)

        return asset
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
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
