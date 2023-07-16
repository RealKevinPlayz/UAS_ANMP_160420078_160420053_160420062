package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine(
    @ColumnInfo(name="medicine_name")
    var medicineName:String,
    @ColumnInfo(name="medicine_desc")
    var medicineDesc:String,
    @ColumnInfo(name="medicine_dose")
    var medicineDose:String,
    @ColumnInfo(name="medicine_composition")
    var medicineComposition:String,
    @ColumnInfo(name="medicine_warning")
    var medicineWarning:String,
    @ColumnInfo(name="medicine_photo_url")
    var medicinePhotoUrl:String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}