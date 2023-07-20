package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.User
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildArticleDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ArticleListViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    var articleLD = MutableLiveData<List<Article>>()
    var articleLoadErrorLD = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    fun addArticle(article: Article){
        launch {
            var db = buildArticleDB(getApplication())
            db.articleDao().insertAll(article)
        }
    }
    fun refreshArticle() {
        loadingLD.value = true
        articleLoadErrorLD.value = false
        launch {
            var db = buildArticleDB(getApplication())
            articleLD.postValue(db.articleDao().selectAllArticle())
        }
    }

    /*
    fun insertArticle(article: Article) {
        launch {
            var db = buildArticleDB(getApplication())
            db.articleDao().insertAll(article)
        }
    }

    fun deleteArticle(article: Article) {
        launch {
            val articleDb = buildArticleDB(getApplication())
            articleDb.articleDao().deleteArticle(article)
        }
    }

    fun updateDefault(){
        launch {
            var articleData = Article("Regular Exercise: Key for Heart Health", "Regular exercise is essential for a healthy heart. It strengthens the heart, improves blood circulation, and reduces the risk of cardiovascular diseases. Studies consistently show that individuals who exercise regularly have a lower likelihood of developing heart disease, high blood pressure, and obesity. Incorporating activities like walking, running, swimming, or cycling into daily routines significantly benefits the cardiovascular system. Exercise also contributes to overall well-being by managing stress, improving mood, boosting energy levels, and promoting better sleep. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous exercise per week for optimal heart health.", "https://blog.1life.co.uk/hubfs/Why%20You%20Should%20Have%20a%20Regular%20Exercise%20Routine.jpg")

            var db = buildArticleDB(getApplication())
            db.articleDao().insertAll(articleData)
        }
    }
    */

}