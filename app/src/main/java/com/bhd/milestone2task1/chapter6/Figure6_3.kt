package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import kotlin.random.Random

class Figure6_3 : AppCompatActivity() {
    val color = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.GRAY)
    val colorSource = arrayOf(R.drawable.red, R.drawable.blue, R.drawable.green, R.drawable.gray)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.figure6_3)

        getMainLayout()
    }

    fun getMainLayout(){
        val mainLayout = findViewById<LinearLayout>(R.id.figure6_3_asset_layout)
        mainLayout.addView(getAsset1())
    }

    fun getAsset1(): View {
        val asset = layoutInflater.inflate(R.layout.figure6_3_asset, null)

        val pieChart = asset.findViewById<PieChartView>(R.id.figure6_3_pie_chart)

        val value: MutableList<Float> = arrayListOf()
        value.add(randomInt(30).toFloat() + 10)
        value.add(randomInt(30).toFloat() + 10)
        value.add(randomInt(30).toFloat() + 10)
        value.add(100 - value[0] - value[1] - value[2])

        val sliceValue = mutableListOf<SliceValue>(
            SliceValue(value[0], Color.RED),
            SliceValue(value[1], color[1]),
            SliceValue(value[2], color[2]),
            SliceValue(value[3], color[3])
        )

        val pieData = PieChartData(sliceValue)
        pieData.setHasCenterCircle(true)
        pieData.centerText1 = "$" + randomInt(2000)
        pieData.centerText1FontSize = 30
        pieData.centerText1Color = Color.BLACK
        pieData.centerText2 = "Monthly"

        pieChart.pieChartData = pieData

        //get sublayout
        val subLayout = asset.findViewById<LinearLayout>(R.id.figure6_3_note_layout)
        for (i in (0..3)){
            index = i
            subLayout.addView(getAsset2())
        }

        return asset
    }


    fun getAsset2(): View{
        val asset = layoutInflater.inflate(R.layout.figure6_3_asset2, null)

        val text1 = asset.findViewById<TextView>(R.id.figure6_3_asset2_text1)
        text1.text = randomText(10)

        val text2 = asset.findViewById<TextView>(R.id.figure6_3_asset2_text2)
        text2.text = "$" + randomInt(2000)

        val img = asset.findViewById<CircleImageView>(R.id.figure6_3_circle)
        Glide.with(this).load(colorSource[index]).into(img)

        return asset
    }


    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max))
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length + 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }
}
