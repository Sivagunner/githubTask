package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class DataFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view1 = inflater.inflate(R.layout.fragment_data, container, false)

        val button = view1.findViewById<Button>(R.id.button)
        button.setOnClickListener{
            findNavController().navigate(R.id.homeFragment)
        }
        return view1
    }
}



