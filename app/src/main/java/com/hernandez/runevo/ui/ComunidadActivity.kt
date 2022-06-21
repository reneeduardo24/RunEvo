package com.hernandez.runevo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hernandez.runevo.R
import com.hernandez.runevo.adapters.ComunidadPagerAdapter

class ComunidadActivity: AppCompatActivity() {

    var tabTitle = arrayOf("Carreras", "Desafíos", "Amigos")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunidad)

        var pager = findViewById<ViewPager2>(R.id.comunidadPager)
        var tl = findViewById<TabLayout>(R.id.tab_comunidad)
        pager.adapter = ComunidadPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager){
                tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}