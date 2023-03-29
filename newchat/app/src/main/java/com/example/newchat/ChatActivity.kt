package com.example.newchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newchat.databinding.ActivityChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChatBinding
    private lateinit var adapter: ChatAdapter
    private val chatMessages = mutableListOf<ChatMessage>()
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        adapter = ChatAdapter(chatMessages,auth?.currentUser?.uid ?: "")
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        listenForMessages()

        button_send.setOnClickListener {
            sendMessage()
        }
        buttonSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun listenForMessages() {
        val ref = FirebaseDatabase.getInstance().getReference("/messages")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                chatMessages.clear()
                snapshot.children.forEach { data ->
                    val message = data.getValue(ChatMessage::class.java)
                    message?.let { chatMessages.add(it) }
                }
                adapter.notifyDataSetChanged()
                recyclerView.scrollToPosition(chatMessages.size - 1)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }


    private fun sendMessage() {
        // Get the message text from the input field
        val messageText = binding.editTextMessage.text.toString().trim()

        // Check if the message is not empty
        if (messageText.isNotEmpty()) {
            // Get user info from Firebase
            val userRef =
                FirebaseDatabase.getInstance().getReference("/users/${auth.currentUser?.uid}")
            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                // When we get the user data
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Create a new message and send it
                    val displayName = snapshot.child("displayName").value.toString()

                    val chatMessage = ChatMessage(
                        message = messageText,
                        sender = auth.currentUser?.uid ?: "",
                        timestamp = System.currentTimeMillis(),
                        displayName = displayName
                    )

                    val ref = FirebaseDatabase.getInstance().getReference("/messages").push()
                    ref.setValue(chatMessage)
                        .addOnSuccessListener {
                            // Clear the input field
                            binding.editTextMessage.setText("")
                        }
                        .addOnFailureListener { exception ->
                            // Show an error message if sending fails
                            Toast.makeText(
                                this@ChatActivity,
                                "Failed to send message: ${exception.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error when fetching user data
                }
            })
        } else {
            // Show a message if the input is empty
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signOut() {
        auth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}