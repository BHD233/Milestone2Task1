package com.bhd.milestone2task1

import android.os.Bundle
import android.provider.ContactsContract
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.nio.channels.GatheringByteChannel
import java.util.*

class Listmenu1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listmenu1)

        getInterface()
    }

    fun getInterface(){
        val button1 = findViewById<ImageButton>(R.id.listmenuButton1)
        Glide.with(button1).load(R.drawable.setting).override(50,50).into(button1)

        val button2 = findViewById<ImageButton>(R.id.listmenuButton2)
        Glide.with(button2).load(R.drawable.mail).override(50,50).into(button2)


        val data = RandomData()

        val gridview = findViewById<ListView>(R.id.listView)

        val adapter = ListMenuAdapter(this, data)

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

        return result
    }
}
