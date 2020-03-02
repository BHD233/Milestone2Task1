package com.bhd.milestone2task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.accordion_list_group.view.*
import kotlinx.android.synthetic.main.accordion_list_item.view.*


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

class ExpandableListAdapter(val _context: Context,  var listDataHeader: ArrayList<String>,
                            val listChild: HashMap<String, String> // header titles
    // child data in format of header title, child title
) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return listChild.get(listDataHeader[groupPosition])!!
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val childText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.accordion_list_item, null)
        }

        convertView!!.lblListItem.text = childText

        val txtListChild = convertView!!
                .findViewById(R.id.lblListItem) as TextView
        txtListChild.text = childText

        return convertView!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
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
                              convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.accordion_list_group, null)
        }

        convertView!!.lblListHeader.text = headerTitle

        return convertView!!
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}

class RegisPersonalizationAdapter(private var c: Context, var infor: List<DataForSpringboard>) : BaseAdapter() {

    override fun getCount(): Int   {  return infor.size  }
    override fun getItem(i: Int): Any {  return infor[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.regis_asset, viewGroup, false)
        }

        //reference textviews and imageviews from our layout
        val imageView = view!!.findViewById<ImageView>(R.id.regisImg1)

        Glide.with(view!!).load(infor[i].img).into(imageView)

        val textView = view!!.findViewById<TextView>(R.id.regisText)
        textView.text = infor[i].title

        return view
    }
}

class MultiStepAdapter(private var c: Context, var infor: List<DataForSpringboard>) : BaseAdapter() {

    override fun getCount(): Int   {  return infor.size  }
    override fun getItem(i: Int): Any {  return infor[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.multi_asset, viewGroup, false)
        }

        //reference textviews and imageviews from our layout
        val imageView = view!!.findViewById<ImageView>(R.id.multiImg1)

        Glide.with(view!!).load(infor[i].img).into(imageView)

        val textView = view!!.findViewById<TextView>(R.id.multiText)
        textView.text = infor[i].title

        return view
    }
}