package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Facility
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildArticleDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildFacilityDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildServiceDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FacilityListViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    var facilityLD = MutableLiveData<List<Facility>>()
    var facilityLoadErrorLD = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addFacility(facility: Facility){
        launch {
            var db = buildFacilityDB(getApplication())
            db.facilityDao().insertAll(facility)
        }
    }
    fun refreshFacility(hospital_id: Int) {
        loadingLD.value = true
        facilityLoadErrorLD.value = false
        launch {
            var db = buildFacilityDB(getApplication())
            facilityLD.postValue(db.facilityDao().selectAllFacilities(hospital_id))
        }
    }
}