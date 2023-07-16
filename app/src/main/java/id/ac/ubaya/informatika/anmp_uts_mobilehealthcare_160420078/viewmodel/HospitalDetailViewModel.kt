package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital

class HospitalDetailViewModel : ViewModel() {
    val hospitalLD = MutableLiveData<Hospital>()
    fun fetch(id:String, hospitalName:String, hospitalWebsite:String, hospitalAddress:String,
              hospitalPhone:String, hospitalPhotoUrl:String, hospitalRating:String) {
        val hospitalData = Hospital(hospitalName, hospitalWebsite, hospitalAddress, hospitalPhone,
            hospitalPhotoUrl, hospitalRating)
        hospitalLD.value = hospitalData
    }
}
