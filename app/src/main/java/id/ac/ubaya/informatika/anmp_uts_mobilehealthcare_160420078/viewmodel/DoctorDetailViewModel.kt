package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDoctorDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DoctorDetailViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    var doctorLD = MutableLiveData<Doctor>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun fetch(id: Int) {
        launch {
            var db = buildDoctorDB(getApplication())
            doctorLD.postValue(db.doctorDao().selectDoctor(id))
        }
    }
}