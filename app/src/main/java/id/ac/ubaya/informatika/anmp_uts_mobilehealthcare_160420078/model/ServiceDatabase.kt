package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_SERVICE

@Database(entities = [Service::class], version =  1)
abstract class ServiceDatabase: RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
    companion object {
        @Volatile private var instance: ServiceDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ServiceDatabase::class.java,
                DB_SERVICE
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