package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.ArticleListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*
import kotlinx.android.synthetic.main.fragment_doctors_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), ArticleLayoutInterface {
    private lateinit var viewModel: ArticleListViewModel
    private var articleListAdapter = ArticleListAdapter(arrayListOf(), { item -> viewModel.clearTaskArticle(item) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        viewModel.refreshArticle()
        articlesRecView.layoutManager = LinearLayoutManager(context)
        articlesRecView.adapter = articleListAdapter

        refreshLayout.setOnRefreshListener {
            articlesRecView.visibility = View.GONE
            txtArticleListError.visibility = View.GONE
            articlesListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshArticle()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.articleLD.observe(viewLifecycleOwner, Observer {
            articleListAdapter.updateArticleList(it)
        })
        viewModel.articleLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtArticleListError.visibility = View.VISIBLE
            } else {
                txtArticleListError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                articlesRecView.visibility = View.GONE
                articlesListProgressLoad.visibility = View.VISIBLE
            } else {
                articlesRecView.visibility = View.VISIBLE
                articlesListProgressLoad.visibility = View.GONE
            }
        })
    }
}