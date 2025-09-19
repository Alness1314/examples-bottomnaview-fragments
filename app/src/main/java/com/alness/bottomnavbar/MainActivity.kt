package com.alness.bottomnavbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.alness.bottomnavbar.databinding.ActivityMainBinding
import com.alness.bottomnavbar.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Cargar fragment por defecto (ej. Home)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
            loadFragment(SettingsFragment())
        }

        binding.apply {
            clickListener()
        }
    }

    private fun clickListener() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home -> loadFragment(HomeFragment())
                R.id.settings -> loadFragment(SettingsFragment())
                R.id.about -> Toast.makeText(this, "Clicked About", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(this, "Clicked Logout", Toast.LENGTH_SHORT).show()

            }
            return@setOnItemSelectedListener true
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}