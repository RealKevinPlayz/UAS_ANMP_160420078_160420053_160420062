package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor

class DoctorListViewModel(application: Application): AndroidViewModel(application){
    val doctorLD = MutableLiveData<ArrayList<Doctor>>()
    val doctorLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingLD.value = true
        doctorLoadErrorLD.value = false



        val doctorsJson = "[{'Id' : '1','doctorName' : 'dr. Prettysun Ang Mellow, Sp.PD'," +
                "'doctorSpecialty' : 'Dokter Penyakit Dalam'," +
                "'doctorAddress' : 'Jl. Kenjeran No.506, Kalijudan, Mulyorejo, Kota Surabaya, Jawa Timur 60134, Indonesia'," +
                "'doctorPhone' : '372409518135','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1552352865/image_doctor/prettysun.jpg.jpg'," +
                "'doctorRating' : '5'},{'Id' : '2','doctorName' : 'dr. Andry Sultana, Sp.PD, FINASIM','doctorSpecialty' : 'Dokter Penyakit Dalam'," +
                "'doctorAddress' : 'Jl. Mayjen Sungkono No.20, Pakis, Kec. Sawahan, Kota Surabaya, Jawa Timur 60256'," +
                "'doctorPhone' : '821039564722','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1639018087/image_doctor/dr.%20Andry%20Sultana%2C%20Sp.PD.jpg.jpg'," +
                "'doctorRating' : '4.5'},{'Id' : '3','doctorName' : 'dr. Dimple Gobind Nagrani, Sp.A','doctorSpecialty' : 'Dokter Anak'," +
                "'doctorAddress' : 'Jl. Teuku Cik Ditiro No.28 Menteng Jakarta Pusat, Menteng, RT.9/RW.2, Gondangdia, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10350, Indonesia'," +
                "'doctorPhone' : '305718493216','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1584974182/image_doctor/dr.%20Dimple%20Gobind%20Nagrani%2C%20Sp.A.jpg.jpg'," +
                "'doctorRating' : '4.5'}]"

        val sType = object : TypeToken<ArrayList<Doctor>>() { }.type
        val result = Gson().fromJson<ArrayList<Doctor>>(doctorsJson, sType)

        doctorLD.value = result
        doctorLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }


}