package com.example.okidoki.tabexperiment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager?, val numOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return TabFragment1()
            1 -> return TabFragment2()
            2 -> return TabFragment3()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}