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
}
