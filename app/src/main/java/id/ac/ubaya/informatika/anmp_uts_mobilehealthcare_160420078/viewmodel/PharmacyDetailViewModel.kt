package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildMedicineDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildPharmacyDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PharmacyDetailViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val pharmacyLD = MutableLiveData<Pharmacy>()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")
    fun fetch(id: Int) {
        launch {
            var db = buildPharmacyDB(getApplication())
            pharmacyLD.postValue(db.pharmacyDao().selectPharmacy(id))
        }
    }
}