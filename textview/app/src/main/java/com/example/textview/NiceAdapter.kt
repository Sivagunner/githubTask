package com.example.textview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class NiceAdapter(private val inflater: ArrayList<coursettModal>, private val courseList1: ArrayList<coursettModal>,) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = object : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate( R.layout.activity_main,parent, false)) {}

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {}

    override fun getItemCount() = 1
}
