package com.example.textview


import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),CourseRVAdapter.OnItemClickListener {

    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
    lateinit var courseRV: RecyclerView
    private lateinit var courseRVAdapter:CourseRVAdapter
    private lateinit var headadapter:NiceAdapter
    private lateinit var courseList: ArrayList<CourseRVModal>
    private lateinit var  courseList1: ArrayList<coursettModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // on below line we are initializing
        // our views with their ids.
        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
        courseList = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(this, 2)

        courseRV.layoutManager = layoutManager

        // on below line we are initializing our adapter
        courseRVAdapter = CourseRVAdapter(courseList, this)
        //headadapter = NiceAdapter(courseList1,this)

        // on below line we are setting
        // adapter to our recycler view.
       //courseRV.adapter = ConcatAdapter(headadapter, courseRVAdapter)
        courseRV.adapter = courseRVAdapter

        // on below line we are adding data to our list
        courseList.add(CourseRVModal("austria", R.drawable.austria))
        courseList.add(CourseRVModal("Malaysia", R.drawable.malaysiaflag))
        courseList.add(CourseRVModal("India", R.drawable.india))
        courseList.add(CourseRVModal("mexico", R.drawable.mexico))


        // on below line we are notifying adapter
        // that data has been updated.
        courseRVAdapter.notifyDataSetChanged()

    }

    override fun onItemClick(position: Int) {
        val clickedItem = courseList[position]
        val power = clickedItem.courseName

        Toast.makeText(this," $power clicked", Toast.LENGTH_SHORT).show()

       // clickedItem.courseName="done"
        findViewById<TextView>(R.id.idTVHeading).text = power

        val temp: ArrayList<CourseRVModal> = courseList
        temp.forEachIndexed { index, courseRVModal ->
            if (courseRVModal.courseName == power) {
                courseList[index].isSelected = true
            } else {
                courseList[index].isSelected = false
            }
        }
        courseRVAdapter.notifyDataSetChanged()
      //  courseRVAdapter.notifyItemChanged(position)
    }
}
