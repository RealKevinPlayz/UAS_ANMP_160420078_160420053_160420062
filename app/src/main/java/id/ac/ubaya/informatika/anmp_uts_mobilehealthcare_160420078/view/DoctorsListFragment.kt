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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*

class DoctorsListFragment : Fragment() {

    private lateinit var viewModel: DoctorListViewModel
    private val doctorListAdapter = DoctorListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctors_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoctorListViewModel::class.java)
        viewModel.refresh()
        doctorsRecView.layoutManager = LinearLayoutManager(context)
        doctorsRecView.adapter = doctorListAdapter

        refreshLayout.setOnRefreshListener {
            doctorsRecView.visibility = View.GONE
            txtDoctorListError.visibility = View.GONE
            doctorsListProgressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.doctorLD.observe(viewLifecycleOwner, Observer {
            doctorListAdapter.updateStudentList(it)
        })

        viewModel.doctorLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtDoctorListError.visibility = View.VISIBLE
            } else {
                txtDoctorListError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                doctorsRecView.visibility = View.GONE
                doctorsListProgressLoad.visibility = View.VISIBLE
            } else {
                doctorsRecView.visibility = View.VISIBLE
                doctorsListProgressLoad.visibility = View.GONE
            }
        })

    }


}