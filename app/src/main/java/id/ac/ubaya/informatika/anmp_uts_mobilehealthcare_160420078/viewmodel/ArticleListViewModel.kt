package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildArticleDB
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ArticleListViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    var articleLD = MutableLiveData<List<Article>>()
    val todoLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refreshArticle() {
        loadingLD.value = true
        todoLoadErrorLD.value = false
        launch {
            var articleDb = buildArticleDB(getApplication())
            articleLD.postValue(articleDb.articleDao().selectAllArticle())
        }
    }

    fun insertArticle(article: Article) {
        launch {
            var articleDb = buildArticleDB(getApplication())
            articleDb.articleDao().insertAll(article)
        }
    }

    fun deleteArticle(article: Article) {
        launch {
            val articleDb = buildArticleDB(getApplication())
            articleDb.articleDao().deleteArticle(article)
        }
    }
}