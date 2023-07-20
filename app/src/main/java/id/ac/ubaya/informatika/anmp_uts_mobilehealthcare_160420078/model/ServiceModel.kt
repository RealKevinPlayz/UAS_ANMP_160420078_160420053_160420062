package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Service(
    @ColumnInfo(name="hospital_id")
    var hospitalID: Int,
    @ColumnInfo(name="service_name")
    var serviceName: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}