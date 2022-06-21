package com.hernandez.runevo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hernandez.runevo.ui.fragments.*

class ComunidadPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CarrerasFragment()
            1 -> DesafiosComFragment()
            2 -> AmigosFragment()
            else -> CarrerasFragment()
        }
    }
}