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

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineListViewModel

import kotlinx.android.synthetic.main.fragment_hospital_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_medicines_list.*

class MedicinesListFragment : Fragment() {
    private lateinit var viewModel: MedicineListViewModel
    private val medicineListAdapter = MedicineListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicines_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MedicineListViewModel::class.java)
        viewModel.refresh()
        medicinesRecView.layoutManager = LinearLayoutManager(context)
        medicinesRecView.adapter = medicineListAdapter

        refreshLayout.setOnRefreshListener {
            medicinesRecView.visibility = View.GONE
            txtMedicineListError.visibility = View.GONE
            medicinesListProgressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.medicineLD.observe(viewLifecycleOwner, Observer {
            medicineListAdapter.updateMedicineList(it)
        })

        viewModel.medicineLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtMedicineListError.visibility = View.VISIBLE
            } else {
                txtMedicineListError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                medicinesRecView.visibility = View.GONE
                medicinesListProgressLoad.visibility = View.VISIBLE
            } else {
                medicinesRecView.visibility = View.VISIBLE
                medicinesListProgressLoad.visibility = View.GONE
            }
        })

    }
}