package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Doctor(
    @ColumnInfo(name = "doctor_name")
    var doctorName:String,
    @ColumnInfo(name = "doctor_specialty")
    var doctorSpecialty:String,
    @ColumnInfo(name = "doctor_address")
    var doctorAddress:String,
    @ColumnInfo(name = "doctor_phone")
    var doctorPhone:String,
    @ColumnInfo(name = "doctor_photo_url")
    var doctorPhotoUrl:String,
    @ColumnInfo(name = "doctor_rating")
    var doctorRating:Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}