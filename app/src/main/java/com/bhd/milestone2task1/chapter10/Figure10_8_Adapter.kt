package com.bhd.milestone2task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.accordion_list_group.view.*
import kotlinx.android.synthetic.main.accordion_list_item.view.*
import kotlinx.android.synthetic.main.figure10_8_item.view.*
import kotlinx.android.synthetic.main.figure10_8_list_group.view.*


class Figure10_8_Adapter(val _context: Context, var listDataHeader: ArrayList<String>,
                            val listChild: HashMap<String, ArrayList<String>> // header titles
    // child data in format of header title, child title
) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return listChild.get(listDataHeader[groupPosition])!![childPosititon]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView

        val childText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.figure10_8_item, null)
        }

        convertView!!.figure10_8_item_text.text = childText

        return convertView!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listChild.get(listDataHeader[groupPosition])!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this.listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return this.listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.figure10_8_list_group, null)
        }

        convertView!!.figure10_8_group_text.text = headerTitle

        return convertView!!
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}


