package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FacilityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg facility: Facility)

    @Query("SELECT * FROM facility WHERE hospital_id = :hospital_id")
    fun selectAllFacilities(hospital_id: Int): List<Facility>
}