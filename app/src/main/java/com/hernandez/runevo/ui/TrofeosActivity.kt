package com.hernandez.runevo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hernandez.runevo.R
import com.hernandez.runevo.adapters.TrofeosPagerAdapter

class TrofeosActivity : AppCompatActivity() {

    var tabTitle = arrayOf("Logros", "Desafíos", "Récords")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trofeos)

        var pager = findViewById<ViewPager2>(R.id.trofeosPager)
        var tl = findViewById<TabLayout>(R.id.tab_trofeos)
        pager.adapter = TrofeosPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager){
            tab, position ->
                tab.text = tabTitle[position]
        }.attach()
    }
}