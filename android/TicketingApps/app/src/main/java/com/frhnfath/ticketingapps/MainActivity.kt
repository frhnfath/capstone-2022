package com.frhnfath.ticketingapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val seatView = findViewById<SeatsView>(R.id.seats_view)
        val button = findViewById<Button>(R.id.finish_button)
        button.setOnClickListener {
            seatView.seat?.let {
                Toast.makeText(this, "Your seat is number ${it.name}.", Toast.LENGTH_SHORT).show()
            } ?: run {
                Toast.makeText(this, "Please choose your seat.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}