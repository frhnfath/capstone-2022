package com.frhnfath.mywidgets

import java.util.*

class NumberGenerator {
    fun generate(max: Int) : Int {
        val random = Random()
        return random.nextInt(max)
    }
}