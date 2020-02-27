package com.bhd.milestone2task1


import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import java.nio.channels.GatheringByteChannel
import java.util.*
import kotlin.collections.HashMap

class Accordion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accordion)

        val toolbar: Toolbar = findViewById(R.id.accordion_toolbar)
        setSupportActionBar(toolbar)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandable_list)

        val data1 = RandomData()
        val data2 = RandomData()

        val hashtable = HashMap<String, String>()

        for(i in(0..data1.size - 1)){
            hashtable.set(data1[i], data2[i])
        }

        val apdapter = ExpandableListAdapter(this, data1, hashtable)

        expandableListView.setAdapter(apdapter)
        expandableListView.setIndicatorBounds(900, expandableListView.width)
    }

    fun RandomData(i: Int = 8): ArrayList<String>{
        val result: MutableList<String> = arrayListOf()

        for (i in 0..i){
            val titleRadom = Random().nextInt(200).toString()

            result.add(titleRadom)
        }

        return result as ArrayList<String>
    }
}