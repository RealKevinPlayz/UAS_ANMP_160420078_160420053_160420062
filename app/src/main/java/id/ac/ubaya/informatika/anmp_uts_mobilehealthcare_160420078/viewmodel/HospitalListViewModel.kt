package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital

class HospitalListViewModel(application: Application): AndroidViewModel(application){
    val hospitalLD = MutableLiveData<ArrayList<Hospital>>()
    val hospitalLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingLD.value = true
        hospitalLoadErrorLD.value = false

        val hospitalsJson = "[{'hospitalId' : '1','hospitalName' : 'Rumah Sakit Mitra Keluarga Kenjeran'," +
                "'hospitalWebsite' : 'https://www.mitrakeluarga.com/kenjeran/menu-fasilitas-rs'," +
                "'hospitalAddress' : 'Jl. Raya Kenjeran 506, Surabaya'," +
                "'hospitalPhone' : '0813 9787 1313','hospitalPhotoUrl' : 'https://lh3.googleusercontent.com/p/AF1QipOzC1O5ko6qJqEcZtYCboaL4FsmHL1o2irqPeG9=s680-w680-h510'," +
                "'hospitalRating' : '4.5'}]"

        val sType = object : TypeToken<ArrayList<Hospital>>() { }.type
        val result = Gson().fromJson<ArrayList<Hospital>>(hospitalsJson, sType)

        hospitalLD.value = result
        hospitalLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }


}