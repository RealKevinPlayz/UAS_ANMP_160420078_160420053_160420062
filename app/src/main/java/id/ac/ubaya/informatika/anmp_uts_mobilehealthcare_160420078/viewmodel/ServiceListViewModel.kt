package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Service
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildArticleDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildServiceDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ServiceListViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    var serviceLD = MutableLiveData<List<Service>>()
    var serviceLoadErrorLD = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addService(service: Service){
        launch {
            var db = buildServiceDB(getApplication())
            db.serviceDao().insertAll(service)
        }
    }
    fun refreshService(hospital_id: Int) {
        loadingLD.value = true
        serviceLoadErrorLD.value = false
        launch {
            var db = buildServiceDB(getApplication())
            serviceLD.postValue(db.serviceDao().selectAllService(hospital_id))
        }
    }
}