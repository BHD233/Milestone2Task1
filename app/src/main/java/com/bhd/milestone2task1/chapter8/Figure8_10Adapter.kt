package com.bhd.milestone2task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bhd.milestone2task1.DataForSpringboard
import com.bhd.milestone2task1.R
import com.bumptech.glide.Glide

class Figure8_10Adapter(private var c: Context, var infor: Array<String>, var img: Array<Int>, var color: Array<Int>) : BaseAdapter() {

    override fun getCount(): Int   {  return infor.size  }
    override fun getItem(i: Int): Any {  return infor[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.figure8_10_asset, viewGroup, false)
        }

        //reference textviews and imageviews from our layout
        val imageView = view!!.findViewById<ImageView>(R.id.figure8_10_img)
        Glide.with(view!!).load(img[i]).into(imageView)

        val textView = view!!.findViewById<TextView>(R.id.figure8_10_text)
        textView.text = infor[i]

        val layout = view!!.findViewById<LinearLayout>(R.id.figure8_10_asset_layout)
        layout.setBackgroundResource(color[i])

        return view
    }
}