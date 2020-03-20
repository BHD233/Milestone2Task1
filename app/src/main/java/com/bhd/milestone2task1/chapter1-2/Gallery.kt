package com.bhd.milestone2task1

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.nio.channels.GatheringByteChannel
import java.util.*

class Gallery : AppCompatActivity() {

    val img = arrayListOf<Int>(R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4,
        R.drawable.q5, R.drawable.q6, R.drawable.q7, R.drawable.q8, R.drawable.q9,
        R.drawable.q10, R.drawable.q11, R.drawable.q12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery)

        getInterface()
    }

    fun getInterface(){
       //get 3 main title each title have 4 detail
        val galleryView = findViewById<LinearLayout>(R.id.galerryView)

        for (i in (0..2)){
            //title
            val title= TextView(this)
            title.text = Random().nextInt(200).toString()
            title.setTextColor(Color.WHITE)
            title.textSize = 30f
            title.setPadding(20,20,0,20)

            galleryView.addView(title)

            val scrollView = HorizontalScrollView(this)
            scrollView.setPadding(20,20,20,20)
            val layout = LinearLayout(this)

            for (j in (0..3)){
                var curLayout = LinearLayout(this)
                curLayout.orientation = LinearLayout.VERTICAL
                curLayout.setPadding(10,0,10,0)

                val textView = TextView(this)
                textView.setTextColor(Color.WHITE)
                textView.gravity = Gravity.CENTER_HORIZONTAL
                textView.text = (Random().nextInt(200) + 100).toString()
                textView.setBackgroundColor(Color.BLACK)
                title.textSize = 24f

                val imageView = ImageView(this)
                Glide.with(this).load(img[i * 3 + j]).override(500,200).into(imageView)

                curLayout.addView(imageView)
                curLayout.addView(textView)

                layout.addView(curLayout)
            }

            scrollView.addView(layout)
            galleryView.addView(scrollView)
        }
    }
}
