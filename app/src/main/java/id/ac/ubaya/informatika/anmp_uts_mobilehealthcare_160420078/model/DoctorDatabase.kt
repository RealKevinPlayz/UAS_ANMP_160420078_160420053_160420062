package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_DOCTOR

@Database(entities = [Doctor::class], version =  1)
abstract class DoctorDatabase: RoomDatabase() {
    abstract fun doctorDao(): DoctorDao
    companion object {
        @Volatile private var instance: DoctorDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DoctorDatabase::class.java,
                DB_DOCTOR
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