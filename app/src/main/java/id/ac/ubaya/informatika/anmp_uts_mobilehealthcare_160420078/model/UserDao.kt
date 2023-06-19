package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user:User)

    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>

    @Query("SELECT * FROM user WHERE username = :username and password = :password")
    fun selectUser(username: String, password: String): User

    @Delete
    fun deleteUser(user: User)

    @Query("update user set username=:username, first_name=:firstName, last_name=:lastName, password=:password where id=:id")
    fun update(username: String, firstName: String, lastName: String, password: String, id: Int)
}