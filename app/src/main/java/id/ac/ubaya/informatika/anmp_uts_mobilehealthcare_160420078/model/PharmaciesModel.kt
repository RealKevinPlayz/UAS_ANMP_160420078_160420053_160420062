package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import com.google.gson.annotations.SerializedName

data class Pharmacy(
    val id:String?,
    val pharmacyName:String?,
    val pharmacyOpeningHour:String?,
    val pharmacyAddress:String?,
    val pharmacyPhone:String?,
    val pharmacyPhotoUrl:String,
    val pharmacyRating:Int?
)