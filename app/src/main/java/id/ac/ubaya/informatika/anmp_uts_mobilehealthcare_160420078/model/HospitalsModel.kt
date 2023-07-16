package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hospital(
    @ColumnInfo(name="hospital_name")
    var hospitalName:String,
    @ColumnInfo(name="hospital_website")
    var hospitalWebsite:String,
    @ColumnInfo(name="hospital_address")
    var hospitalAddress:String,
    @ColumnInfo(name="hospital_phone")
    var hospitalPhone:String,
    @ColumnInfo(name="hospital_photo_url")
    var hospitalPhotoUrl:String,
    @ColumnInfo(name="hospital_rating")
    var hospitalRating:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}