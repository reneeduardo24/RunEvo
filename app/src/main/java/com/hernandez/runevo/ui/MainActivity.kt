package com.hernandez.runevo.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hernandez.runevo.R
import com.hernandez.runevo.adapters.TrofeosPagerAdapter
import com.hernandez.runevo.databinding.ActivityMainBinding
import com.hernandez.runevo.util.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.navHostFragment)
        navigateToTrackingFragmentIfNeeded(intent)


        setSupportActionBar(binding.toolbar)


        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemReselectedListener { /*NO OPERATION HERE*/ }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment, R.id.comunidadActivity, R.id
                    .trofeosActivity->
                    binding.bottomNavigationView.visibility = View.VISIBLE
                else -> binding.bottomNavigationView.visibility = View.GONE
            }

        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?) {
        if (intent?.action == ACTION_SHOW_TRACKING_FRAGMENT) {
            navController.navigate(R.id.action_global_trackingFragment)
        }
    }
}