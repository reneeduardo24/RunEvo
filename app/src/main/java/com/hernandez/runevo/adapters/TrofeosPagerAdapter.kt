package com.hernandez.runevo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hernandez.runevo.ui.fragments.LogrosFragment
import com.hernandez.runevo.ui.fragments.DesafiosFragment
import com.hernandez.runevo.ui.fragments.RecordsFragment

class TrofeosPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LogrosFragment()
            1 -> DesafiosFragment()
            2 -> RecordsFragment()
            else -> LogrosFragment()
        }
    }


}