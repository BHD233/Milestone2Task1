package com.bhd.milestone2task1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.*

class MultiStep1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_steps)

        getInterface()
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.multiGridView)

        val adapter = MultiStepAdapter(this, data)

        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val a = view.findViewById<ImageView>(R.id.multiImg2)

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

    fun onNextButtonClicked(view: View){
        var intent = Intent(this, MultiStep2::class.java)
        startActivity(intent)
    }

    fun onPreviousButtonClicked(view: View){

    }
}

class MultiStep2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_steps)

        val textView = findViewById<TextView>(R.id.multiStepTextView)
        textView.text = "2/4 Select your favorite"

        getInterface()
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.multiGridView)

        val adapter = MultiStepAdapter(this, data)

        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val a = view.findViewById<ImageView>(R.id.multiImg2)

            if (a.visibility == View.INVISIBLE) {
                a.visibility = View.VISIBLE
            } else{
                a.visibility = View.INVISIBLE
            }
        }
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.g, R.drawable.d, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.a, R.drawable.b, R.drawable.h, R.drawable.i,
            R.drawable.a, R.drawable.b, R.drawable.c)

        for (i in 0..11){
            val titleRadom = Random().nextInt(1000).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result as List<DataForSpringboard>
    }

    fun onNextButtonClicked(view: View){
        var intent = Intent(this, MultiStep3::class.java)
        startActivity(intent)
    }

    fun onPreviousButtonClicked(view: View){
        var intent = Intent(this, MultiStep1::class.java)
        startActivity(intent)
    }
}

class MultiStep3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_steps)

        getInterface()

        val textView = findViewById<TextView>(R.id.multiStepTextView)
        textView.text = "3/4 Select your favorite"
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.multiGridView)

        val adapter = MultiStepAdapter(this, data)

        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val a = view.findViewById<ImageView>(R.id.multiImg2)

            if (a.visibility == View.INVISIBLE) {
                a.visibility = View.VISIBLE
            } else{
                a.visibility = View.INVISIBLE
            }
        }
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.i, R.drawable.g, R.drawable.b,
            R.drawable.d, R.drawable.e, R.drawable.e, R.drawable.h, R.drawable.f, R.drawable.i,
            R.drawable.a, R.drawable.b, R.drawable.c)

        for (i in 0..11){
            val titleRadom = Random().nextInt(1000).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result as List<DataForSpringboard>
    }

    fun onNextButtonClicked(view: View){
        var intent = Intent(this, MultiStep4::class.java)
        startActivity(intent)
    }

    fun onPreviousButtonClicked(view: View){
        var intent = Intent(this, MultiStep2::class.java)
        startActivity(intent)
    }
}

class MultiStep4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_steps)

        getInterface()

        val textView = findViewById<TextView>(R.id.multiStepTextView)
        textView.text = "4/4 Select your favorite"
    }

    fun getInterface(){
        val data = RandomData()

        val gridview = findViewById<GridView>(R.id.multiGridView)

        val adapter = MultiStepAdapter(this, data)

        gridview.adapter = adapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val a = view.findViewById<ImageView>(R.id.multiImg2)

            if (a.visibility == View.INVISIBLE) {
                a.visibility = View.VISIBLE
            } else{
                a.visibility = View.INVISIBLE
            }
        }
    }

    fun RandomData(): List<DataForSpringboard>{
        val result: MutableList<DataForSpringboard> = arrayListOf()

        val imgs = arrayListOf<Int>(R.drawable.g, R.drawable.h, R.drawable.i,
            R.drawable.e, R.drawable.a, R.drawable.f, R.drawable.d, R.drawable.b, R.drawable.i,
            R.drawable.a, R.drawable.b, R.drawable.c)

        for (i in 0..11){
            val titleRadom = Random().nextInt(1000).toString()

            result.add(DataForSpringboard(titleRadom, imgs[i]))
        }

        return result as List<DataForSpringboard>
    }

    fun onNextButtonClicked(view: View){
    }

    fun onPreviousButtonClicked(view: View){
        var intent = Intent(this, MultiStep3::class.java)
        startActivity(intent)
    }
}
