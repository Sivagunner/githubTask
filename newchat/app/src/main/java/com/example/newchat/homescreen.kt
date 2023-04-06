package com.example.newchat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newchat.databinding.ActivityHomescreenBinding


class homescreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomescreenBinding
    private lateinit var groupAdapter: GroupListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up onClick listeners for the buttons
       /* binding.buttonChat.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }*/

        binding.buttonUserList.setOnClickListener {
            startActivity(Intent(this, UserProfile::class.java))
        }

    }
}