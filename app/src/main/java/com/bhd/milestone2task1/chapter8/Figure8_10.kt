package com.bhd.milestone2task1

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Figure8_10 : AppCompatActivity() {

    val imgSrc = arrayOf(R.drawable.g, R.drawable.b, R.drawable.d, R.drawable.i, R.drawable.f, R.drawable.e)
    var strSrc = arrayOf(randomText(6), randomText(6), randomText(6),
                         randomText(6), randomText(6), randomText(6))
    val color = arrayOf(R.color.blueLight, R.color.orangeBackground, R.color.blueDark,
                        R.color.yellow, R.color.green, R.color.greenYellow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure8_10)

        getInterface()
    }

    fun getInterface(){
        val gridview = findViewById<GridView>(R.id.figure8_10_grid_view)

        val adapter = Figure8_10Adapter(this, strSrc, imgSrc, color)

        gridview.adapter = adapter
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