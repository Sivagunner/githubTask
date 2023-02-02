package com.example.seekbar01


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var submitButton: Button? = null
    var simpleSeekBar: SeekBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initiate  views
        simpleSeekBar = findViewById<View>(R.id.seekBar2) as SeekBar
        // perform seek bar change listener event used for getting the progress value
        simpleSeekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var progressChangedValue = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(
                    this@MainActivity, "Seek bar progress is :$progressChangedValue",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}