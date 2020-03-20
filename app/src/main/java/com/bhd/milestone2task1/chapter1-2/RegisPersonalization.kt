package com.bhd.milestone2task1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.*

class RegisPersonalization : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.regis_personalization)

        getInterface()
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.regisGridView)

        val adapter = RegisPersonalizationAdapter(this, data)

        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val a = view.findViewById<ImageView>(R.id.regisImg2)

            if (a.visibility == View.INVISIBLE) {
                a.visibility = View.VISIBLE
            } else{
                a.visibility = View.INVISIBLE
            }
        }
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i,
            R.drawable.a, R.drawable.b, R.drawable.c)

        for (i in 0..11){
            val titleRadom = Random().nextInt(1000).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result as List<DataForSpringboard>
    }
}
