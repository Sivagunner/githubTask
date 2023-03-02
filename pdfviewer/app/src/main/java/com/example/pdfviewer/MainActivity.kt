package com.example.pdfviewer

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdfviewer.databinding.ActivityMainBinding
import com.github.barteksc.pdfviewer.PDFView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pdfview1.fromAsset("HLBHotNSpicyFeb23 Contest T&C, Guide and FAQs.pdf")
            .enableSwipe(true)
            .swipeHorizontal(true)
            .load()
    }
}

