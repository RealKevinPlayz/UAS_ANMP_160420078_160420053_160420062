package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDoctorDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildHospitalDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HospitalListViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    val hospitalLD = MutableLiveData<List<Hospital>>()
    val hospitalLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addHospital(hospital: Hospital){
        launch {
            var db = buildHospitalDB(getApplication())
            db.hospitalDao().insertAll(hospital)
        }
    }

    fun refreshHospital() {
        loadingLD.value = true
        hospitalLoadErrorLD.value = false
        launch {
            var db = buildHospitalDB(getApplication())
            hospitalLD.postValue(db.hospitalDao().selectAllHospital())
        }
        /*
        val hospitalsJson = "[{'hospitalId' : '1','hospitalName' : 'Rumah Sakit Mitra Keluarga Kenjeran'," +
                "'hospitalWebsite' : 'www.mitrakeluarga.com/kenjeran/menu-fasilitas-rs'," +
                "'hospitalAddress' : 'Jl. Raya Kenjeran 506, Surabaya'," +
                "'hospitalPhone' : '0813-9787-1313','hospitalPhotoUrl' : 'https://lh3.googleusercontent.com/p/AF1QipOzC1O5ko6qJqEcZtYCboaL4FsmHL1o2irqPeG9=s680-w680-h510'," +
                "'hospitalRating' : '4.5'}, {'hospitalId' : '2','hospitalName' : 'Memorial Hospital'," +
                "'hospitalWebsite' : 'www.memorialhospital.com'," +
                "'hospitalAddress' : '456 Oak St, Anytown, USA'," +
                "'hospitalPhone' : '3421-2232-1990','hospitalPhotoUrl' : 'https://wearememorial.com/wp-content/uploads/2022/08/D75_7357-1-1200x607.jpg'," +
                "'hospitalRating' : '4.2'}, {'hospitalId' : '3','hospitalName' : 'Mercy Hospital'," +
                "'hospitalWebsite' : 'www.mercyhospital.com'," +
                "'hospitalAddress' : '789 Elm St, Anytown, USA'," +
                "'hospitalPhone' : '3425-9787-1121','hospitalPhotoUrl' : 'https://www.mercy.net/content/dam/mercy/en/images/Mercy_Hospital_NWA_night.jpg'," +
                "'hospitalRating' : '3.8'}, " +
                "{'hospitalId' : '4','hospitalName' : 'University Hospital'," +
                "'hospitalWebsite' : 'www.universityhospital.com'," +
                "'hospitalAddress' : '222 Pine St, Anytown, USA'," +
                "'hospitalPhone' : '5551-3456-0990','hospitalPhotoUrl' : 'https://www.muhealth.org/sites/default/files/styles/slider_hero_full_width/public/2017-08/160412%20UHFlowersTulips-31-952_0.jpg?itok=dtRLxHxw'," +
                "'hospitalRating' : '4.5'}]"

        val sType = object : TypeToken<ArrayList<Hospital>>() { }.type
        val result = Gson().fromJson<ArrayList<Hospital>>(hospitalsJson, sType)

        hospitalLD.value = result
        hospitalLoadErrorLD.value = false
        loadingLD.value = false
        */
    }

    fun clearTaskHospital(hospital: Hospital){
        launch {
            var db = buildHospitalDB(getApplication())
        }
    }
}