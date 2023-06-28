package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ArticleListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage
import kotlinx.android.synthetic.main.doctors_list_item.view.*

var articleList = null

class ArticleListAdapter(val articleList:ArrayList<Article>) : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(var view: ArticleListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.view.article = articleList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ArticleListItemBinding>(inflater, R.layout.article_list_item, parent, false)

        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    fun updateArticleList(newArticleList: List<Article>) {
        articleList.clear()
        articleList.addAll(newArticleList)
        notifyDataSetChanged()
    }
}
