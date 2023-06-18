package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user:User)

    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>

    @Query("SELECT * FROM user WHERE id= :id")
    fun selectUser(id:Int): User

    @Delete
    fun deleteUser(user: User)
}