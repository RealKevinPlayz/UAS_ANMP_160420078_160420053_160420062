package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ServiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg service: Service)

    @Query("SELECT * FROM service WHERE hospital_id = :hospital_id")
    fun selectAllService(hospital_id: Int): List<Service>
}