package com.timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TimePickerDialogFragment.OnTimeSelected{

    private lateinit var binding : ActivityMainBinding
    private lateinit var timePickerDialogFragment: TimePickerDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize(){
        timePickerDialogFragment = TimePickerDialogFragment(this)
        binding.tvTimePicker.setOnClickListener(){
            timePickerDialogFragment.show(supportFragmentManager,"TimePicker")
        }
    }

    override fun onTimeSelected(hourOfDay: Int, minute: Int) {
        Toast.makeText(this, "$hourOfDay  $minute",Toast.LENGTH_SHORT).show()
    }
}