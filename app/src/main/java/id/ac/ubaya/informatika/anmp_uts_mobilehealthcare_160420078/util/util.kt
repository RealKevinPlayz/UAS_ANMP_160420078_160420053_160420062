package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.room.Room
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.ArticleDatabase
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.UserDatabase

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        //.into(this)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

var DB_NAME = "userdb"
fun buildDB(context: Context):UserDatabase{
    var db = Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME).build()
    return db
}
fun buildArticleDB(context: Context):ArticleDatabase{
    var articleDb = Room.databaseBuilder(context, ArticleDatabase::class.java, DB_NAME).build()
    return articleDb
}
