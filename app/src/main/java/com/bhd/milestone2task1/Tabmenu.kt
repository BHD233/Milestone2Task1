package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout


class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment1, container, false)
    }
}

class Fragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment2, container, false)
    }
}

class Fragment3 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment3, container, false)
    }
}

class Fragment4 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment4, container, false)
    }
}

class Tabmenu : AppCompatActivity() {

    val iconNonBackground = arrayListOf<Int>(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d)
    val iconBackground = arrayListOf<Int>(R.drawable.a_with_blue_back, R.drawable.b_with_blue_back,
        R.drawable.c_with_blue_back, R.drawable.d_with_blue_back)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabmenu)

        val refreshButton = findViewById<ImageButton>(R.id.refreshButton)
        Glide.with(this).load(R.drawable.refresh).override(70,70).into(refreshButton)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)

        val viewpager_main = findViewById<ViewPager>(R.id.viewpager_main)
        val tabs_main = findViewById<TabLayout>(R.id.tabs_main)

        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)

        //get icon
        for (i in (0..3)){
            tabs_main.getTabAt(i)?.setCustomView(R.layout.tab_icon)
            var img = tabs_main.getTabAt(i)?.view?.findViewById<ImageView>(R.id.tabIconImg) as ImageView
            Glide.with(this).load(iconNonBackground[i]).into(img)
        }

        //highlight tab 0
        tabs_main.getTabAt(0)?.view?.findViewById<ConstraintLayout>(R.id.tabIcon)?.setBackgroundResource(R.color.blueBackground)

        tabs_main.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                tabs_main.getTabAt(tab.position)?.view?.findViewById<ConstraintLayout>(R.id.tabIcon)?.setBackgroundResource(R.color.blueBackground)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabs_main.getTabAt(tab.position)?.view?.findViewById<ConstraintLayout>(R.id.tabIcon)?.setBackgroundResource(R.color.blackdark)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }
}