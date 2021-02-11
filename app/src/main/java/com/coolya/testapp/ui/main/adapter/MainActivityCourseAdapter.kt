package com.coolya.testapp.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.coolya.testapp.ui.fragment.course.crypto.ui.CryptoFragment
import com.coolya.testapp.ui.fragment.course.privat.ui.PrivatFragment

class MainActivityCourseAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int  = 2

    override fun createFragment(position: Int): Fragment  = when(position){
        0-> PrivatFragment()
        else -> CryptoFragment()
    }
}