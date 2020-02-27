package com.bhd.milestone2task1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Fragment1()
            }
            1 ->{
                Fragment2()
            }
            2 -> {
                Fragment3()
            }
            else -> {
                return Fragment4()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }
}