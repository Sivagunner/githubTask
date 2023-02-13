package com.example.refreshlayoutnew

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.refreshlayoutnew.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.button.setOnClickListener{
            binding.backgroind.setBackgroundColor(
                rgb(getRandom(255),getRandom(255),getRandom(255))
            )

        }
        binding.swipeRefreshLayout.setOnRefreshListener{
            binding.backgroind.setBackgroundColor(
                Color.rgb(red(255), green(255), blue(255))
            )
            binding.swipeRefreshLayout.isRefreshing=false

        }
    }
    private fun getRandom(limit:Int):Int{
        return (Math.random()*255).toInt()
    }
}

