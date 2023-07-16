package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Medicine

class MedicineDetailViewModel : ViewModel() {
    val medicineLD = MutableLiveData<Medicine>()
    fun fetch(medicineName:String, medicineDesc:String, medicineDose:String,
              medicineComposition:String, medicineWarning:String, medicinePhotoUrl:String) {
        val medicineData = Medicine(medicineName, medicineDesc, medicineDose, medicineComposition,
            medicineWarning, medicinePhotoUrl)
        medicineLD.value = medicineData
    }
}
