package com.example.registerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registerapp.R
import com.example.registerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("NAME")

        binding.tvHome.text = "Hello $name"

    }
}