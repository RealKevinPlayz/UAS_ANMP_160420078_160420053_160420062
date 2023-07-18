package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.*

@Dao
interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg doctor: Doctor)

    @Query("SELECT * FROM doctor")
    fun selectAllDoctor(): List<Doctor>

    @Query("select * from doctor where id = :id")
    fun selectDoctor(id: Int): Doctor
}