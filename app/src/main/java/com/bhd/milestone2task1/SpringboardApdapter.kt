package com.bhd.milestone2task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import com.bumptech.glide.Glide


class SpringboardApdapter(private var c: Context, var infor: List<DataForSpringboard>) : BaseAdapter() {

    override fun getCount(): Int   {  return infor.size  }
    override fun getItem(i: Int): Any {  return infor[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.springboard_apdapter, viewGroup, false)
        }

        //reference textviews and imageviews from our layout
        val imageView = view!!.findViewById<ImageView>(R.id.springboardImg)

        Glide.with(view!!).load(infor[i].img).into(imageView)

        val textView = view!!.findViewById<TextView>(R.id.springboardText)
        textView.text = infor[i].title

        return view
    }
}

class ListMenuAdapter(private var c: Context, var infor: List<DataForSpringboard>) : BaseAdapter() {

    override fun getCount(): Int   {  return infor.size  }
    override fun getItem(i: Int): Any {  return infor[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.listmenu_adapter, viewGroup, false)
        }

        //reference textviews and imageviews from our layout
        val imageView = view!!.findViewById<ImageView>(R.id.listmenuImg)

        Glide.with(view!!).load(infor[i].img).into(imageView)

        val textView = view!!.findViewById<TextView>(R.id.listmenuText)
        textView.text = infor[i].title



        return view
    }
}