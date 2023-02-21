package com.example.navigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R.*

// TODO: Rename parameter arguments, choose names that match

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.button6)
        button.setOnClickListener{
            findNavController().navigate(R.id.dataFragment)
        }
        return view
    }
}

