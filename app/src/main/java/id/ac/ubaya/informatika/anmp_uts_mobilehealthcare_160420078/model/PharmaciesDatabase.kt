package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_PHARMACY

@Database(entities = [Pharmacy::class], version =  1)
abstract class PharmaciesDatabase: RoomDatabase() {
    abstract fun pharmacyDao(): PharmaciesDao
    companion object {
        @Volatile private var instance: PharmaciesDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PharmaciesDatabase::class.java,
                DB_PHARMACY
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