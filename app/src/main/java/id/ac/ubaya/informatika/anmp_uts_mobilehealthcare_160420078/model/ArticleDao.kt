package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.*

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg article: Article)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertArticle(vararg article: Array<Article>)

    @Query("SELECT * FROM article")
    fun selectAllArticle(): List<Article>

    @Query("SELECT * FROM article WHERE id = :id")
    fun selectArticle(id: Int): Article

    @Delete
    fun deleteArticle(article: Article)
}