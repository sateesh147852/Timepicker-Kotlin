package com.timepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment(val onTimeSelected : OnTimeSelected) : DialogFragment() , TimePickerDialog.OnTimeSetListener {

    private var calendar : Calendar = Calendar.getInstance()
    private var hourOfDay : Int = 0
    private var minute : Int = 0

    init {
        hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        minute = calendar.get(Calendar.MINUTE)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         return TimePickerDialog(context,this,hourOfDay,minute,false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        onTimeSelected.onTimeSelected(hourOfDay,minute)
    }

    interface OnTimeSelected{
        fun onTimeSelected(hourOfDay: Int, minute: Int)
    }
}