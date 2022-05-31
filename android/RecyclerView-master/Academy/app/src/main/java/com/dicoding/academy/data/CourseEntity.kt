package com.dicoding.academy.data

data class CourseEntity(
    var CourseId: String,
    var title: String,
    var description: String,
    var deadline: String,
    var bookmarked: Boolean = false,
    var imagePath: String
)