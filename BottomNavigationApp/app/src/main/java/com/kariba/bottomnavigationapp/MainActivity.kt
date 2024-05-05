package com.kariba.bottomnavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.internal.ContextUtils.getActivity
import com.kariba.bottomnavigationapp.databinding.ActivityMainLayoutBinding
import com.kariba.bottomnavigationapp.fragment.HomeFragment
import com.kariba.bottomnavigationapp.fragment.MessageFragment
import com.kariba.bottomnavigationapp.fragment.SettingsFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        loadFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when(item.itemId){

                R.id.home -> {
                    loadFragment(HomeFragment())
                    true

                }

                R.id.settings -> {
                    loadFragment(SettingsFragment())
                    true

                }

                R.id.message -> {
                    loadFragment(MessageFragment())
                    true

                }

                else -> false

            }

        }

    }

    private fun loadFragment(fragment: Fragment) {
        var transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment).commit()
    }
}