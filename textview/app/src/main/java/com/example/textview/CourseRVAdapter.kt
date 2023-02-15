package com.example.textview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// on below line we are creating
// a course rv adapter class.
class CourseRVAdapter(
    // on below line we are passing variables
    // as course list and context
    private val courseList: ArrayList<CourseRVModal>,
    //private val context: Context,
    private val context: OnItemClickListener
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        val course = courseList.get(position)
        holder.courseNameTV.text = course.courseName
        holder.courseIV.setImageResource(course.courseImg)

        if (course.isSelected) {
            holder.itemView.setBackgroundColor(Color.BLUE)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }


       // holder.courseTitles.text = courseList.get(position).courseTitles
        //holder.courseTitles.setOnClickListener {

       // }
        holder.courseNameTV.setOnClickListener {

        }

    }

     override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return courseList.size
    }

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    OnClickListener{
        // on below line we are initializing our course name text view and our image view.
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
       // val courseTitles: TextView = itemView.findViewById(R.id.idTVHeading)
        val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {



            val position =absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                context.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}
