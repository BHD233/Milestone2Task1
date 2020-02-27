package com.bhd.milestone2task1

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu1.*
import java.nio.channels.GatheringByteChannel

class SlideDrawer : AppCompatActivity() {
    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slide_drawer)

        val toolbar: Toolbar = findViewById(R.id.slide_drawer_toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Slide Drawer Example"

        val imageButton = findViewById<ImageButton>(R.id.slide_drawer_button)
        Glide.with(this).load(R.drawable.setting).override(50, 50).into(imageButton)

        drawer = findViewById<DrawerLayout>(R.id.slide_drawer_layout)

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_draw_open,R.string.nav_draw_close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}