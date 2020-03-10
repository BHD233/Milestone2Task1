package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class HeaderlessTable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.headerless_table)
        getInterface(this)
    }

    fun getInterface(context: Context){
        for (j in (0..9)){
            baseAsset(randomData(), randomData(), randomData(), randomData(), this)
        }
    }

    fun baseAsset(flight: String, dest: String, gate: String, depart: String, context: Context, titleColor: Int = Color.BLACK){
        val space = 15

        val flightLayout = findViewById<LinearLayout>(R.id.flightLayout)
        val destLayout = findViewById<LinearLayout>(R.id.destLayout)
        val gateLayout = findViewById<LinearLayout>(R.id.gateLayout)
        val departLayout = findViewById<LinearLayout>(R.id.departLayout)

        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = space
        params.bottomMargin = space

        val flightView = TextView(context)
        flightView.text = flight
        flightView.setTypeface(null, Typeface.BOLD)
        flightView.textSize = 24f
        flightView.setTextColor(titleColor)
        flightView.setTextColor(getColor(R.color.orangeBackground))
        flightView.layoutParams = params
        flightView.setBackgroundResource(R.color.blackLight)
        flightView.setPadding(5,space,0,space)

        val destView = TextView(context)
        destView.text = dest
        destView.textSize = 24f
        destView.setTextColor(getColor(R.color.blueBackground))
        destView.layoutParams = params
        destView.setBackgroundResource(R.color.blackLight)
        destView.setPadding(0,space,0,space)

        val gateView = TextView(context)
        gateView.text = gate
        gateView.setTypeface(null, Typeface.BOLD)
        gateView.textSize = 24f
        gateView.setTextColor(getColor(R.color.greenLight))
        gateView.layoutParams = params
        gateView.setBackgroundResource(R.color.blackLight)
        gateView.setPadding(0,space,0,space)

        val departView = TextView(context)
        departView.text = depart
        departView.textSize = 24f
        departView.setTextColor(getColor(R.color.orangeBackground))
        departView.layoutParams = params
        departView.setBackgroundResource(R.color.blackLight)
        departView.setPadding(0,space,0,space)


        flightLayout.addView(flightView)
        destLayout.addView(destView)
        gateLayout.addView(gateView)
        departLayout.addView(departView)
    }

    fun randomData(): String{
        return (Random.nextInt(2000) + 100).toString()
    }
}
