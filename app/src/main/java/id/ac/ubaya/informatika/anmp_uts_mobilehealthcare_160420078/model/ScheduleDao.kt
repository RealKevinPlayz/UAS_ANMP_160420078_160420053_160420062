package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg schedule: Schedule)

    @Query("SELECT * FROM schedule")
    fun selectAllSchedule(): List<Schedule>
}