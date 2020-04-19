package com.bhd.milestone2task1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout


class Figure11_2 : AppCompatActivity() {
    lateinit var drawerItem: Array<Figure11_2_item>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.bhd.milestone2task1.R.layout.figure11_2)
        
        var size = 7

        var displayMetrics = DisplayMetrics()
        var display = windowManager.defaultDisplay.getMetrics(displayMetrics)
        var height = displayMetrics.heightPixels
        
        drawerItem = arrayOf(Figure11_2_item("NEWS", height / (size + 1), Color.BLACK),
            Figure11_2_item("SPORTS", height / (size  + 1), Color.RED),
            Figure11_2_item("LIFE", height / (size + 1), Color.BLACK),
            Figure11_2_item("MONEY", height / (size + 1), Color.BLACK),
            Figure11_2_item("TECH", height / (size + 1), Color.BLACK),
            Figure11_2_item("TRAVEL", height / (size + 1), Color.BLACK),
            Figure11_2_item("OPINION", height / (size + 1), Color.BLACK))

        getInterface(this)
    }

    fun getInterface(context: Context){
        
        var a = drawerItem

        val adapter =
            DrawerItemCustomAdapter(this, com.bhd.milestone2task1.R.layout.figure11_2_drawer_item, a)
        var drawer = findViewById<DrawerLayout>(com.bhd.milestone2task1.R.id.figure11_2_drawer)

        var drawerList = findViewById<ListView>(com.bhd.milestone2task1.R.id.figure11_2_left_drawer)
        drawerList.adapter = adapter
        drawerList.setOnItemClickListener(DrawerItemClickListener())

        var toolbar = findViewById<Toolbar>(com.bhd.milestone2task1.R.id.figure11_2_toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, com.bhd.milestone2task1.R.string.nav_draw_open,
            com.bhd.milestone2task1.R.string.nav_draw_close)

        toggle.syncState()
    }

    private class DrawerItemClickListener : OnItemClickListener {
        override fun onItemClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            val a: Figure11_2_item = parent?.getItemAtPosition(position) as Figure11_2_item
        }
        
        
    }
}