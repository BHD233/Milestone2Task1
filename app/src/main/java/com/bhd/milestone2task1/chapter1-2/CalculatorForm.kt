package com.bhd.milestone2task1

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView

class CalculatorForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_form)

        getInterface()
    }

    fun getInterface(){
        val priceSeekBar = findViewById<SeekBar>(R.id.calculatorPrice)
        val downSeekBar = findViewById<SeekBar>(R.id.calculatorDown)
        val rateSeekBar = findViewById<SeekBar>(R.id.calculatorRate)

        val seekBars = arrayOf(priceSeekBar, downSeekBar, rateSeekBar)

        val priceTextView = findViewById<TextView>(R.id.priceTextView)
        val downTextView = findViewById<TextView>(R.id.downTextView)
        val rateTextView = findViewById<TextView>(R.id.rateTextView)

        val textView = arrayOf(priceTextView, downTextView, rateTextView)

        for (i in 0..seekBars.size - 1) {
            seekBars[i].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, j: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                    textView[i].text = seekBar.progress.toString()

                    if (i == 0){
                        textView[i].text = "$" + textView[i].text.toString()
                    } else{
                        textView[i].text = textView[i].text.toString() + "%"
                    }

                    val pieChart = findViewById<PieChartView>(R.id.calculatorPieChart)

                    val data: MutableList<SliceValue> = arrayListOf()

                    data.add(SliceValue(seekBars[0].progress.toFloat() / 1000, Color.BLACK))
                    data.add(SliceValue(seekBars[1].progress.toFloat(), Color.BLUE))
                    data.add(SliceValue(seekBars[2].progress.toFloat(), Color.RED))

                    val pieData = PieChartData(data)

                    pieChart.pieChartData = pieData
                }

                override fun onStartTrackingTouch(seek: SeekBar) {
                    // write custom code for progress is started
                }

                override fun onStopTrackingTouch(seek: SeekBar) {
                    // write custom code for progress is stopped
                }
            })
        }
    }
}

