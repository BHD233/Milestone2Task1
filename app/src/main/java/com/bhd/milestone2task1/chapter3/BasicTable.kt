package com.bhd.milestone2task1

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.listmenu1.*
import org.w3c.dom.Text
import java.util.*

class BasicTable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_table)

        getInterFace()
    }

    fun getInterFace(){
        val listView = findViewById<ListView>(R.id.basicTableListView)

        val title = RandomData()
        title[0] = "AL EAST"
        title[7] = "AL CENTER"
        title[14] = "AL WEST"
        val w = RandomData()
        val l = RandomData()
        val gb = RandomData()

        for (i in (0..10)step 7){
            w[i] = "W"
            l[i] = "L"
            gb[i] = "GB"
        }

        val apdapter = HeadlessListAdapter(this, title, w, l, gb)

        listView.adapter = apdapter
    }

    fun RandomData(): MutableList<String>{
        val result: MutableList<String> = arrayListOf()

        for (i in 0..20){
            val titleRadom = (Random().nextInt(90) + 10).toString()

            result.add(titleRadom)
        }

        return result
    }
}
