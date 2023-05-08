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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.HospitalListViewModel
import kotlinx.android.synthetic.main.fragment_hospital_list.*

class HospitalListFragment : Fragment() {

    private lateinit var viewModel: HospitalListViewModel
    private val hospitalListAdapter = HospitalListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HospitalListViewModel::class.java)
        viewModel.refresh()
        hospitalsRecView.layoutManager = LinearLayoutManager(context)
        hospitalsRecView.adapter = hospitalListAdapter

        refreshLayout.setOnRefreshListener {
            hospitalsRecView.visibility = View.GONE
            txtHospitalListError.visibility = View.GONE
            hospitalsListProgressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.hospitalLD.observe(viewLifecycleOwner, Observer {
            hospitalListAdapter.updateHospitalList(it)
        })

        viewModel.hospitalLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtHospitalListError.visibility = View.VISIBLE
            } else {
                txtHospitalListError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                hospitalsRecView.visibility = View.GONE
                hospitalsListProgressLoad.visibility = View.VISIBLE
            } else {
                hospitalsRecView.visibility = View.VISIBLE
                hospitalsListProgressLoad.visibility = View.GONE
            }
        })

    }
}