package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HospitalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg hospital: Hospital)

    @Query("SELECT * FROM hospital")
    fun selectAllHospital(): List<Hospital>

    @Query("select * from hospital where id = :id")
    fun selectHospital(id: Int): Hospital
}