package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_FACILITY
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_MEDICINE

@Database(entities = [Facility::class], version =  1)
abstract class FacilityDatabase: RoomDatabase() {
    abstract fun facilityDao(): FacilityDao
    companion object {
        @Volatile private var instance: FacilityDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FacilityDatabase::class.java,
                DB_FACILITY
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