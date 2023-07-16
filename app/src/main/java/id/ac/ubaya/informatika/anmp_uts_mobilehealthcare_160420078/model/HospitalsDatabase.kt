package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_HOSPITAL

@Database(entities = [Hospital::class], version =  1)
abstract class HospitalsDatabase: RoomDatabase() {
    abstract fun hospitalDao(): HospitalsDao
    companion object {
        @Volatile private var instance: HospitalsDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HospitalsDatabase::class.java,
                DB_HOSPITAL
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