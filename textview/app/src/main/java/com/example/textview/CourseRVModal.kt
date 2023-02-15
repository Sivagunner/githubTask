package com.example.textview

import android.icu.text.CaseMap.Title

data class CourseRVModal(
    // on below line we are creating a
    // two variable one for course name
    // and other for course image.
    var courseName: String,
    var courseImg: Int,
    var isSelected: Boolean = false

)