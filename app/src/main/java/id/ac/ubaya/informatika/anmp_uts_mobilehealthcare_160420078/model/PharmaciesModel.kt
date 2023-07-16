package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pharmacy(
    @ColumnInfo(name="pharmacy_name")
    var pharmacyName:String,
    @ColumnInfo(name="pharmacy_opening_hour")
    var pharmacyOpeningHour:String,
    @ColumnInfo(name="pharmacy_address")
    var pharmacyAddress:String,
    @ColumnInfo(name="pharmacy_phone")
    var pharmacyPhone:String,
    @ColumnInfo(name="pharmacy_photo_url")
    var pharmacyPhotoUrl:String,
    @ColumnInfo(name="pharmacy_rating")
    var pharmacyRating:String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}