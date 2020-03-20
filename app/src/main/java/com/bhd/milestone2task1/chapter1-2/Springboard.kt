package com.bhd.milestone2task1

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Springboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.springboard)

        getInterface()
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.springboardView)

        val adapter = SpringboardApdapter(this, data)

        gridview.adapter = adapter
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i)

        for (i in 0..8){
            val titleRadom = Random().nextInt(200).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result as List<DataForSpringboard>
    }

    fun RandomImageSource() : String{
        val preString : String = "https://api.adorable.io/avatar/"
        val lastString : String = ".png"

        var numImg = Random().nextInt() % 1000

        return preString + numImg.toString() + numImg
    }
}
