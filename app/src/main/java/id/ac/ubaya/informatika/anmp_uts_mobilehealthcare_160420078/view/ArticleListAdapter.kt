package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage
import kotlinx.android.synthetic.main.doctors_list_item.view.*

var articleList = null

//class ArticleListAdapter(val articleList:ArrayList<Article>) : ArticleLayoutInterface {
//    class ArticleViewHolder(var view: ArticleLayoutInterface): RecyclerView.ViewHolder(view.root)
//
//    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        holder.view.article = articleList[position]
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view = TodoItemLayoutBinding.inflate(inflater, parent, false)
//
//        return ArticleViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return articleList.size
//    }
//
//    fun updateTodoList(newTodoList: List<Article>) {
//        articleList.clear()
//        articleList.addAll(newTodoList)
//        notifyDataSetChanged()
//    }
//}
