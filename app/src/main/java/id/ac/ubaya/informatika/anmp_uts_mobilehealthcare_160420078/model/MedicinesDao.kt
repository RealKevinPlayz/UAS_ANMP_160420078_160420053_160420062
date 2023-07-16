package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicinesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg medicine: Medicine)

    @Query("SELECT * FROM medicine")
    fun selectAllMedicine(): List<Medicine>
}