package com.dicoding.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculateVolume: Button
    private lateinit var btnCalculateSurfaceArea: Button
    private lateinit var btnCalculateCircumfere: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        tvResult = findViewById(R.id.tv_result)
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume)
        btnCalculateCircumfere = findViewById(R.id.btn_calculate_circumfere)
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area)
        btnSave = findViewById(R.id.btn_save)

        btnSave.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateCircumfere.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val length = edtLength.text.toString().trim()
        val width = edtWidth.text.toString().trim()
        val height = edtHeight.text.toString().trim()

        when{
            length.isEmpty() -> edtLength.error = "This Field Cannot be Empty"
            width.isEmpty() -> edtWidth.error = "This Field Cannot be Empty"
            height.isEmpty() -> edtHeight.error = "This Field Cannot be Empty"
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    v.id == R.id.btn_calculate_circumfere -> {
                        tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    v.id == R.id.btn_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    v.id == R.id.btn_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumfere.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumfere.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}