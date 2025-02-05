package com.example.fragment5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                loadFragment(HomeFragment.newInstance())
                true
            }
            R.id.navigation_dashboard -> {
                loadFragment(DashboardFragment.newInstance())
                true
            }
            R.id.navigation_notifications -> {
                loadFragment(NotificationsFragment.newInstance())
                true
            }
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<BottomNavigationView>(R.id.navigation)
        navigationView.setOnItemSelectedListener(onItemSelectedListener)
    }
}

