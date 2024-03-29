package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_MEDICINE

@Database(entities = [Medicine::class], version =  1)
abstract class MedicinesDatabase: RoomDatabase() {
    abstract fun medicineDao(): MedicinesDao
    companion object {
        @Volatile private var instance: MedicinesDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MedicinesDatabase::class.java,
                DB_MEDICINE
            ).build()
        operator fun invoke(context: Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}