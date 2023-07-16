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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
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
        var article1 = Article("Regular Exercise: Key for Heart Health", "Regular exercise is essential for a healthy heart. It strengthens the heart, improves blood circulation, and reduces the risk of cardiovascular diseases. Studies consistently show that individuals who exercise regularly have a lower likelihood of developing heart disease, high blood pressure, and obesity. Incorporating activities like walking, running, swimming, or cycling into daily routines significantly benefits the cardiovascular system. Exercise also contributes to overall well-being by managing stress, improving mood, boosting energy levels, and promoting better sleep. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous exercise per week for optimal heart health.", "https://blog.1life.co.uk/hubfs/Why%20You%20Should%20Have%20a%20Regular%20Exercise%20Routine.jpg")
        var article2 = Article("The Rise of Telehealth in Healthcare", "Telehealth, the use of technology for remote healthcare, has gained prominence. The COVID-19 pandemic accelerated its adoption, offering access to care during crises and limited physical visits. Telehealth includes video consultations, remote monitoring, and mobile health apps. It improves healthcare accessibility, particularly in rural or underserved areas, reducing wait times and enabling early detection. Telehealth also saves costs by minimizing in-person visits, reducing transportation expenses, and potentially decreasing hospital readmissions. However, it has limitations and not all conditions can be addressed remotely. Patient information privacy and security are crucial in telehealth implementation.", "https://www.pointstar.co.id/wp-content/uploads/2018/01/Telehealth-services.png")
        var article3 = Article("Addressing Healthcare Workforce Shortage in Rural Areas", "Rural areas face healthcare workforce shortages, limiting access to care. Factors like low population density and limited infrastructure contribute to this challenge. Strategies to address the issue include offering incentives to healthcare professionals, such as loan repayment programs and tax benefits, to attract them to rural areas. Creating residency programs and providing professional development opportunities can also help. Collaborations between rural and urban healthcare facilities, telehealth, and expanding healthcare education programs in rural regions can improve access to quality care. Overcoming workforce shortages is crucial to ensure adequate healthcare services for rural populations.", "https://www.expatica.com/app/uploads/sites/10/2014/05/english-countryside.jpg")
        viewModel.addArticle(article1)
        viewModel.addArticle(article2)
        viewModel.addArticle(article3)
    }

    private fun observeViewModel() {
        viewModel.articleLD.observe(viewLifecycleOwner, Observer {
            articleListAdapter.updateArticleList(it)
            if (it.isEmpty()){
                txtArticleListError?.visibility = View.VISIBLE
                articlesListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtArticleListError?.visibility = View.GONE
                articlesListProgressLoad?.visibility = View.GONE
            }
        })
        /*
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
        */
    }
}