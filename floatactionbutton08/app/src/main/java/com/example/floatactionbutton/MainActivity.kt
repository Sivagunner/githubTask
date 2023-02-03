package com.example.floatactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.floatactionbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        setupFloatingActionButton()
    }
    private fun setupFloatingActionButton() {
        binding.fab.setOnClickListener {
            // We are showing only toast message. However, you can do anything you need.
            Toast.makeText(
                applicationContext,
                "You clicked Floating Action Button",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}