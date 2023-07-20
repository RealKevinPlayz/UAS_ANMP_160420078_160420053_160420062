package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Schedule
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildScheduleDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ScheduleListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    var scheduleLD = MutableLiveData<List<Schedule>>()
    var scheduleLoadErrorLD = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addSchedule(schedule: Schedule){
        launch {
            var db = buildScheduleDB(getApplication())
            db.scheduleDao().insertAll(schedule)
        }
    }
    fun refreshSchedule(user_id: Int) {
        Log.wtf("Refreshing the Schedule", "success")
        Log.wtf("User Id on Schedule", user_id.toString())
        loadingLD.value = true
        scheduleLoadErrorLD.value = false
        launch {
            var db = buildScheduleDB(getApplication())
            scheduleLD.postValue(db.scheduleDao().selectAllSchedule(user_id))
        }
    }

}