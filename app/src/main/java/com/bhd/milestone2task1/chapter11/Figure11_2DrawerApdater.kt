package com.bhd.milestone2task1

import android.R
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import org.w3c.dom.Text


class DrawerItemCustomAdapter(
    var mContext: Context,
    var layoutResourceId: Int,
    data: Array<Figure11_2_item>?
) :
    ArrayAdapter<Figure11_2_item?>(mContext, layoutResourceId, data!!) {
    var data: Array<Figure11_2_item>? = null
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var listItem = convertView
        val inflater = (mContext as Activity).layoutInflater
        listItem = inflater.inflate(layoutResourceId, parent, false)

        val layout = listItem.findViewById<LinearLayout>(com.bhd.milestone2task1.R.id.figure11_2_item)

        val textViewName = listItem.findViewById<TextView>(com.bhd.milestone2task1.R.id.figure11_2_text)

        var param = textViewName.layoutParams
        param.height = data!![position].height
        textViewName.layoutParams = param


        val folder: Figure11_2_item = data!![position]

        layout.setBackgroundColor(folder.color)

        textViewName.setText(folder.name)

        return listItem
    }

    override fun getItem(position: Int): Figure11_2_item? {
        return data!![position]
    }

    init {
        this.data = data
    }

}