package com.bhd.milestone2task1

import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.MutableList
import kotlin.collections.arrayListOf
import kotlin.random.Random


class Figure10_8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure10_8)

        val expandableListView = findViewById<ExpandableListView>(R.id.figure10_8_list_view)

        val data1 = randomData(15)

        val hashtable = HashMap<String, ArrayList<String>>()

        for(i in(0..data1.size - 1)){
            hashtable.put(data1[i], randomData(5))
        }

        val apdapter = Figure10_8_Adapter(this, data1, hashtable)

        expandableListView.setAdapter(apdapter)
        expandableListView.setIndicatorBounds(900, expandableListView.width)
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

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }

    fun randomData(i: Int = 8): ArrayList<String> {
        val result: MutableList<String> = arrayListOf()

        for (i in 0..i){
            val titleRadom = randomText(randomInt(5) + 10)

            result.add(titleRadom)
        }

        return result as ArrayList<String>
    }
}