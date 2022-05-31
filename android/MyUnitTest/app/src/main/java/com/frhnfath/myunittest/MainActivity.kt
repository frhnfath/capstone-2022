package com.frhnfath.myunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.frhnfath.myunittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mainViewModel = MainViewModel(CuboidModel())

        activityMainBinding.btnSave.setOnClickListener(this)
        activityMainBinding.btnCalculationSurfaceArea.setOnClickListener(this)
        activityMainBinding.btnCalculationCircumference.setOnClickListener(this)
        activityMainBinding.btnCalculationVolume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val length = activityMainBinding.edtLength.text.toString().trim()
        val width = activityMainBinding.edtWidth.text.toString().trim()
        val height = activityMainBinding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                activityMainBinding.edtLength.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                activityMainBinding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                activityMainBinding.edtHeight.error = "Field ini tidak boleh kosong"
            }
            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculation_circumference -> {
                        activityMainBinding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculation_surface_area -> {
                        activityMainBinding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculation_volume -> {
                        activityMainBinding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }
    private fun visible() {
        activityMainBinding.btnCalculationVolume.visibility = View.VISIBLE
        activityMainBinding.btnCalculationCircumference.visibility = View.VISIBLE
        activityMainBinding.btnCalculationSurfaceArea.visibility = View.VISIBLE
        activityMainBinding.btnSave.visibility = View.GONE
    }
    private fun gone() {
        activityMainBinding.btnCalculationVolume.visibility = View.GONE
        activityMainBinding.btnCalculationCircumference.visibility = View.GONE
        activityMainBinding.btnCalculationSurfaceArea.visibility = View.GONE
        activityMainBinding.btnSave.visibility = View.VISIBLE
    }
}