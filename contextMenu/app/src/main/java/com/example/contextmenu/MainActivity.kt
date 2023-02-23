package com.example.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // creating variables for video view on below line.
    lateinit var messageTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing variable for video view on below line.
        messageTV = findViewById(R.id.idTVMessage)
        // registering context menu on below line.
        registerForContextMenu(messageTV)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // on below line we are setting header title for menu.
        menu!!.setHeaderTitle("Choose Programming Language")
        // on below line we are adding menu items
        menu.add(0, v!!.getId(), 0, "Java")
        menu.add(0, v!!.getId(), 0, "Kotlin")
        menu.add(0, v!!.getId(), 0, "Dart")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // on below line we are setting the selected item text for message text view
        messageTV.text = item.title
        return true
    }
}