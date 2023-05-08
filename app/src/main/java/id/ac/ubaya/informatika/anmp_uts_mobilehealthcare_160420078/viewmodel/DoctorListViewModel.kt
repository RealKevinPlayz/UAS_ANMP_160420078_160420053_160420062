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
                "'doctorAddress' : 'Rumah Sakit Mitra Keluarga Kenjeran, Jl. Kenjeran No.506, Kalijudan, Mulyorejo, Kota Surabaya, Jawa Timur 60134, Indonesia'," +
                "'doctorPhone' : '3724-0951-8135','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1552352865/image_doctor/prettysun.jpg.jpg'," +
                "'doctorRating' : '5'},{'Id' : '2','doctorName' : 'dr. Andry Sultana, Sp.PD, FINASIM','doctorSpecialty' : 'Dokter Penyakit Dalam'," +
                "'doctorAddress' : 'Mayapada Hospital Surabaya, Jl. Mayjen Sungkono No.20, Pakis, Kec. Sawahan, Kota Surabaya, Jawa Timur 60256'," +
                "'doctorPhone' : '8210-3956-4722','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1639018087/image_doctor/dr.%20Andry%20Sultana%2C%20Sp.PD.jpg.jpg'," +
                "'doctorRating' : '4.5'},{'Id' : '3','doctorName' : 'dr. Dimple Gobind Nagrani, Sp.A','doctorSpecialty' : 'Dokter Anak'," +
                "'doctorAddress' : 'Jl. Teuku Cik Ditiro No.28 Menteng Jakarta Pusat, Menteng, RT.9/RW.2, Gondangdia, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10350, Indonesia'," +
                "'doctorPhone' : '3057-1849-3216','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1584974182/image_doctor/dr.%20Dimple%20Gobind%20Nagrani%2C%20Sp.A.jpg.jpg'," +
                "'doctorRating' : '4.5'}, {'Id' : '4','doctorName' : 'dr. Bambang Herwanto, Sp.JP, FIHA'," +
                "'doctorSpecialty' : 'Dokter Penyakit Jantung'," +
                "'doctorAddress' : 'Rumah Sakit Umum Siloam, Jl. Raya Gubeng No.70, Gubeng, Kota SBY, Jawa Timur 60281, Indonesia'," +
                "'doctorPhone' : '8315-0962-6721','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_60,h_60,c_fill,dpr_2.0/v1500451269/image_doctor/Bambang%20Herwanto%2C%20dr.%2C%20SpJP%20%28K%29%2C%20FIHA.JPG.jpg'," +
                "'doctorRating' : '5'},{'Id' : '5','doctorName' : 'dr. Ivana Sugiarto, M.Biomed, Sp.KK','doctorSpecialty' : 'Dokter Kulit'," +
                "'doctorAddress' : 'Mitra Keluarga Kenjeran, Jl. Kenjeran No.506, Kalijudan, Mulyorejo, Kota Surabaya, Jawa Timur 60134, Indonesia'," +
                "'doctorPhone' : '2963-1582-2148','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_60,h_60,c_fill,dpr_2.0/v1607570785/image_doctor/unnamed%20%284%29%20-%20Pita%20Patimah.jpg.jpg'," +
                "'doctorRating' : '4.5'},{'Id' : '6','doctorName' : 'dr. Jose Laksmana Anggowarsito, G.Dimp. Derm, Sp.KK','doctorSpecialty' : 'Dokter Kulit'," +
                "'doctorAddress' : 'Jl. Emerald Mansion TX 10, Lidah Kulon, Kec. Lakarsantri, Kota Surabaya, Jawa Timur 60213'," +
                "'doctorPhone' : '4796-0837-4912','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1599099659/image_doctor/dr.%20Jose%20Laksmana%20Anggowarsito%2C%20G.Dimp.%20Derm%2C%20Sp.KK.png.png'," +
                "'doctorRating' : '4'},{'Id' : '7','doctorName' : 'dr. Moch. Wachid, Sp.THT-KL','doctorSpecialty' : 'Dokter THT'," +
                "'doctorAddress' : 'Rumah Sakit Al-Irsyad, Jl. KH Mas Mansyur No.210-214, Nyamplungan, Pabean Cantian, Kota Surabaya, Jawa Timur 60162, Indonesia'," +
                "'doctorPhone' : '9721-0783-9265','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1615520877/image_doctor/dr.%20Moch.%20Wachid%2C%20Sp.THT-KL.jpg.jpg'," +
                "'doctorRating' : '4.5'},{'Id' : '8','doctorName' : 'dr. Chandra Irwanadi Mohani, Sp.PD, KGH' , 'doctorSpecialty' : 'Dokter Ginjal'," +
                "'doctorAddress' : 'Mitra Keluarga Surabaya, Jl. Satelit Indah II, Darmo Satelit, Tanjungsari, Suko Manunggal, Kota SBY, Jawa Timur 60187, Indonesia'," +
                "'doctorPhone' : '5034-1872-1936','doctorPhotoUrl' : 'https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1551761026/image_doctor/dr-chandra-im.jpg.jpg'," +
                "'doctorRating' : '5'}]"

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