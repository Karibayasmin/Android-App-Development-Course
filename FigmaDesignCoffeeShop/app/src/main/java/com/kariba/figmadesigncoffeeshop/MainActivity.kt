package com.kariba.figmadesigncoffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.kariba.figmadesigncoffeeshop.databinding.ActivityMainLayoutBinding

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}