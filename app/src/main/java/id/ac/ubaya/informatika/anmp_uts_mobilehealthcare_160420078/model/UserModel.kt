package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name="username")
    var username: String,
    @ColumnInfo(name="first_name")
    var firstName: String,
    @ColumnInfo(name="last_name")
    var lastName: String,
    @ColumnInfo(name="password")
    var password: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
//user model