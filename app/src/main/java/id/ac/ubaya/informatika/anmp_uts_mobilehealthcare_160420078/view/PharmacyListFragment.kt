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

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.PharmacyListViewModel

import kotlinx.android.synthetic.main.fragment_hospital_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_pharmacy_list.*

class PharmacyListFragment : Fragment() {
    private lateinit var viewModel: PharmacyListViewModel
    private val pharmacylListAdapter = PharmacyListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pharmacy_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PharmacyListViewModel::class.java)
        viewModel.refresh()
        pharmaciesRecView.layoutManager = LinearLayoutManager(context)
        pharmaciesRecView.adapter = pharmacylListAdapter

        refreshLayout.setOnRefreshListener {
            pharmaciesRecView.visibility = View.GONE
            txtPharmacyListError.visibility = View.GONE
            pharmaciesListProgressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.pharmacyLD.observe(viewLifecycleOwner, Observer {
            pharmacylListAdapter.updatePharmacyList(it)
        })

        viewModel.pharmacyLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtPharmacyListError.visibility = View.VISIBLE
            } else {
                txtPharmacyListError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                pharmaciesRecView.visibility = View.GONE
                pharmaciesListProgressLoad.visibility = View.VISIBLE
            } else {
                pharmaciesRecView.visibility = View.VISIBLE
                pharmaciesListProgressLoad.visibility = View.GONE
            }
        })

    }
}