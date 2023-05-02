package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor

class DoctorDetailViewModel {
    val doctorLD = MutableLiveData<Doctor>()
    fun fetch(id:String, doctorName:String, doctorSpecialty:String, doctorAddress:String, doctorPhone:String, doctorPhotoUrl:String, doctorRating:Int) {
        val doctorData = Doctor(id, doctorName, doctorSpecialty, doctorAddress, doctorPhone, doctorPhotoUrl, doctorRating)
        doctorLD.value = doctorData
    }
}