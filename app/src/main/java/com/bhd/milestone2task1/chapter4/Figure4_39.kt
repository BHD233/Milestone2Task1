package com.bhd.milestone2task1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Figure4_39 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure4_39)

        getInterface()
    }

    fun getInterface(){
        val choice: List<String> = listOf("Best Match", "Price + Shipping: Lowest First","Price + Shipping: Highest First",
        "Price: Highest First", "Time: Ending Soonest", "Time: Newly Listed", "Distance: Nearest First")

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = SpinnerAdapter(this, choice )
        spinner.adapter = adapter

        spinner.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                adapter.selected = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }
}
