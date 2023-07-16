package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDoctorDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildPharmacyDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PharmacyListViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    val pharmacyLD = MutableLiveData<List<Pharmacy>>()
    val pharmacyLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addPharmacy(pharmacy: Pharmacy){
        launch {
            var db = buildPharmacyDB(getApplication())
            db.pharmacyDao().insertAll(pharmacy)
        }
    }

    fun refreshPharmacy() {
        loadingLD.value = true
        pharmacyLoadErrorLD.value = false
        launch {
            var db = buildPharmacyDB(getApplication())
            pharmacyLD.postValue(db.pharmacyDao().selectAllPharmacy())
        }
        /*
        val pharmaciesJson = "[{'pharmacyId': '1', 'pharmacyName': 'Mediplus Pharmacy'," +
                "'pharmacyOpeningHour': '09:00 - 18:00', " +
                "'pharmacyAddress': '123 Main St, Anytown USA'," +
                "'pharmacyPhone': '+1-555-123-4567'," +
                "'pharmacyPhotoUrl': 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Medplus_pharmacy.jpg/2560px-Medplus_pharmacy.jpg', 'pharmacyRating': '4.5'  }, " +
                "{ 'pharmacyId': '2','pharmacyName': 'Green Cross Pharmacy'," +
                "'pharmacyOpeningHour': '08:00 - 20:00'," +
                "'pharmacyAddress': '456 Broad St, Anytown USA'," +
                "'pharmacyPhone': '+1-555-987-6543'," +
                "'pharmacyPhotoUrl': 'https://c.yell.com/t_galleryFit,f_auto/d4afcc9e-cdc4-4e7d-90c1-016fc7c6383f_image_jpeg.jpg', " +
                "'pharmacyRating': '4.2'  }," +
                "{'pharmacyId': '3'," +
                "'pharmacyName': 'Cornerstone Pharmacy','pharmacyOpeningHour': '10:00 - 19:00'," +
                "'pharmacyAddress': '789 Oak St, Anytown USA'," +
                "'pharmacyPhone': '+1-555-234-5678'," +
                "'pharmacyPhotoUrl': 'https://static.spacecrafted.com/bc231dd8ea9f466babf3c6231d703d5c/i/dcd9093e11c54aa48d4e10c47cc33e63/1/4SoifmQpDrHbZJ6W5XJrp/Screen%20Shot%202018-02-27%20at%201.00.49%20PM.png', 'pharmacyRating': '4.9'},  " +
                "{'pharmacyId': '4'," +
                "'pharmacyName': 'Wellness Pharmacy'," +
                "'pharmacyOpeningHour': '08:30 - 21:00'," +
                "'pharmacyAddress': '147 Pine St, Anytown USA'," +
                "'pharmacyPhone': '+1-555-876-5432'," +
                "'pharmacyPhotoUrl': 'https://content.jdmagicbox.com/comp/pune/v7/020pxx20.xx20.200424201005.l9v7/catalogue/wellness-pharmacy-and-beauty-centre-ravet-pune-chemists-x322lpzb0o.jpg'," +
                "'pharmacyRating': '4.7'  }," +
                "{'pharmacyId': '5'," +
                "'pharmacyName': 'Pharma Health'," +
                "'pharmacyOpeningHour': '07:00 - 23:00'," +
                "'pharmacyAddress': '369 Maple St, Anytown USA'," +
                "'pharmacyPhone': '+1-555-345-6789', " +
                "'pharmacyPhotoUrl': 'https://cdn.shopify.com/s/files/1/0579/7422/7003/files/pharmahealth-logo.jpg?v=1661618230&width=300'," +
                "'pharmacyRating': '4.3'}]"

        val sType = object : TypeToken<ArrayList<Pharmacy>>() { }.type
        val result = Gson().fromJson<ArrayList<Pharmacy>>(pharmaciesJson, sType)

        pharmacyLD.value = result
        pharmacyLoadErrorLD.value = false
        loadingLD.value = false
        */
    }

    fun clearTaskPharmacy(pharmacy: Pharmacy){
        launch {
            var db = buildPharmacyDB(getApplication())
        }
    }
}