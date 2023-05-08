package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy

class PharmacyDetailViewModel : ViewModel() {
    val pharmacyLD = MutableLiveData<Pharmacy>()
    fun fetch(pharmacyId:String, pharmacyName:String, pharmacyOpeningHour:String, pharmacyAddress:String,
              pharmacyPhone:String, pharmacyPhotoUrl:String, pharmacyRating:String) {
        val pharmacyData = Pharmacy(pharmacyId, pharmacyName, pharmacyOpeningHour, pharmacyAddress, pharmacyPhone,
            pharmacyPhotoUrl, pharmacyRating)
        pharmacyLD.value = pharmacyData
    }
}
