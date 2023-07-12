package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.DB_2
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.MIGRATION_1_2

@Database(entities = [Article::class], version =  2)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    companion object {
        @Volatile private var instance: ArticleDatabase ?= null
        private val LOCK = Any()
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                DB_2).addMigrations(MIGRATION_1_2).build()
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