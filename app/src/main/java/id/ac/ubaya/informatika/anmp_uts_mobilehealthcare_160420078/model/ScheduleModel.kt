package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Schedule(
    @ColumnInfo(name = "user_id")
    var user_id: Int,
    @ColumnInfo(name = "doctor_id")
    var doctor_id: String,
    @ColumnInfo(name = "date")
    var date: Int,
    @ColumnInfo(name = "description")
    var description: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}