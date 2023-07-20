package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.View
import android.widget.CompoundButton
import androidx.navigation.Navigation

interface ButtonDetailLayoutInterface{
    fun onDoctorButtonDetailClick(v:View){
        val action = DoctorsListFragmentDirections.actionDoctorDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    fun onHospitalButtonDetailClick(v:View){
        val action = HospitalListFragmentDirections.actionHospitalDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    fun onMedicineButtonDetailClick(v:View){
        val action = MedicinesListFragmentDirections.actionMedicineDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    fun onPharmacyButtonDetailClick(v:View){
        val action = PharmacyListFragmentDirections.actionPharmacyDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    fun onCancelProfileClick(v:View){
        Navigation.findNavController(v).popBackStack()
    }

}

interface ButtonAppointmentLayoutInterface{
    fun onButtonAppointmentClick(v:View){
        var action = DoctorsDetailFragmentDirections.actionAppointmentFragment()
        Navigation.findNavController(v).navigate(action)
    }
}

interface DateListener{
    fun onDateClick(v: View)
}

interface TimeListener{
    fun onTimeClick(v: View)
}

interface AppointmentLayoutInterface{
    fun onButtonBooking(v: View)
}

interface ServiceFacilityLayoutInterface{
    fun onButtonService(v: View){
        var action = HospitalDetailFragmentDirections.actionFacilityService()
        Navigation.findNavController(v).navigate(action)
    }
}