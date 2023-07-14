package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor

class DoctorDetailViewModel : ViewModel() {
    val doctorLD = MutableLiveData<Doctor>()
    fun fetch(doctorName:String, doctorSpecialty:String, doctorAddress:String, doctorPhone:String, doctorPhotoUrl:String, doctorRating:Int) {
        val doctorData = Doctor(doctorName, doctorSpecialty, doctorAddress, doctorPhone, doctorPhotoUrl, doctorRating)
        doctorLD.value = doctorData
    }
}