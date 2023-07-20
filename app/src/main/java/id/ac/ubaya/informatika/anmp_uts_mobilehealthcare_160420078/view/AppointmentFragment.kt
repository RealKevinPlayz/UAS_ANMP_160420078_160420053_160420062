package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentAppointmentBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Schedule
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.ScheduleListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_appointment.*
import java.util.*
import java.util.concurrent.TimeUnit

class AppointmentFragment : Fragment(), AppointmentLayoutInterface, DateListener, TimeListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private lateinit var viewModel: ScheduleListViewModel
    private lateinit var dataBinding: FragmentAppointmentBinding
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0
    var userID = 0
    var doctorID = 0
    var doctorName = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_appointment, container, false)
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_appointment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
        var shared = this.requireActivity()
            .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(ScheduleListViewModel::class.java)
        userID = shared.getInt("userID", 0)
        doctorID = shared.getInt("doctorID", 0)
        doctorName = shared.getString("doctorName", "").toString()
        txtDoctorID.text = "Doctor ID : " + doctorID
        txtDoctorName.text = "Doctor Name : " + doctorName
        dataBinding.schedule = Schedule(userID, doctorID, doctorName, 0, "")
        dataBinding.bookinglistener = this
        dataBinding.datelistener = this
        dataBinding.timelistener = this
    }

    override fun onDateClick(v: View) {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        activity?.let {
                it1 -> DatePickerDialog(it1, this, year, month, day).show()
        }
    }

    override fun onTimeClick(v: View) {
        var c = Calendar.getInstance()
        var hour = c.get(Calendar.HOUR_OF_DAY)
        var minute = c.get(Calendar.MINUTE)
        TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity)).show()
    }

    override fun onButtonBooking(v: View) {
        var c = Calendar.getInstance()
        c.set(year, month, day, hour, minute, 0)
        dataBinding.schedule!!.date = (c.timeInMillis/1000L).toInt()
        dataBinding.schedule!!.description = txtDescription.text.toString()
        viewModel.addSchedule(dataBinding.schedule!!)
        Toast.makeText(v.context, "Schedule created", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        dataBinding.txtDate.setText(day.toString().padStart(2, '0') + "-" + month.toString().padStart(2, '0') + "-" + year)
        this.year = year
        this.month = month
        this.day = day
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        dataBinding.txtTime.setText(hour.toString().padStart(2, '0') + ":" + minute.toString().padStart(2, '0'))
        this.hour = hour
        this.minute = minute
    }
}