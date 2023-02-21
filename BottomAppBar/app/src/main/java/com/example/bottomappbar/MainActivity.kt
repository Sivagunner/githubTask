package com.example.bottomappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomAppBar: BottomAppBar = findViewById(R.id.bottom_app_bar)
        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option_1 -> {
                    Toast.makeText(this, "Option 1 Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option_2 -> {
                    Toast.makeText(this, "Option 2 Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
