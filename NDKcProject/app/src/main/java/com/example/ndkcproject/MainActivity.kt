package com.example.ndkcproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nynativelibrary.NativeLib

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addition = NativeLib().Add(20,10)
        val substraction = NativeLib().Subtract(20,10);
        val multiply = NativeLib().Multiply(20,10);

        Log.e("Test","Add: ${addition} Subtract: ${substraction},Multiply: ${multiply}")
    }
}