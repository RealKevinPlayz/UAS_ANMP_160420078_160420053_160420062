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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.HospitalListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*
import kotlinx.android.synthetic.main.fragment_hospital_list.*
import kotlinx.android.synthetic.main.fragment_hospital_list.refreshLayout

class HospitalListFragment : Fragment() {

    private lateinit var viewModel: HospitalListViewModel
    private val hospitalListAdapter = HospitalListAdapter(arrayListOf(), { item -> viewModel.clearTaskHospital(item) })

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
        viewModel.refreshHospital()
        hospitalsRecView.layoutManager = LinearLayoutManager(context)
        hospitalsRecView.adapter = hospitalListAdapter

        refreshLayout.setOnRefreshListener {
            hospitalsRecView.visibility = View.GONE
            txtHospitalListError.visibility = View.GONE
            hospitalsListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshHospital()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
        /*
        var hospital1 = Hospital("Rumah Sakit Mitra Keluarga Kenjeran", "www.mitrakeluarga.com/kenjeran/menu-fasilitas-rs", "Jl. Raya Kenjeran 506, Surabaya", "0813-9787-1313", "https://lh3.googleusercontent.com/p/AF1QipOzC1O5ko6qJqEcZtYCboaL4FsmHL1o2irqPeG9=s680-w680-h510", "4.5")
        var hospital2 = Hospital("Memorial Hospital", "www.memorialhospital.com", "456 Oak St, Anytown, USA", "3421-2232-1990", "https://wearememorial.com/wp-content/uploads/2022/08/D75_7357-1-1200x607.jpg", "4.2")
        var hospital3 = Hospital("Mercy Hospital", "www.mercyhospital.com", "789 Elm St, Anytown, USA", "3425-9787-1121", "https://www.mercy.net/content/dam/mercy/en/images/Mercy_Hospital_NWA_night.jpg", "3.8")
        var hospital4 = Hospital("University Hospital", "www.universityhospital.com", "222 Pine St, Anytown, USA", "5551-3456-0990", "https://www.muhealth.org/sites/default/files/styles/slider_hero_full_width/public/2017-08/160412%20UHFlowersTulips-31-952_0.jpg?itok=dtRLxHxw", "4.5")
        viewModel.addHospital(hospital1)
        viewModel.addHospital(hospital2)
        viewModel.addHospital(hospital3)
        viewModel.addHospital(hospital4)
        */
    }

    fun observeViewModel() {
        viewModel.hospitalLD.observe(viewLifecycleOwner, Observer {
            hospitalListAdapter.updateHospitalList(it)
            if (it.isEmpty()){
                txtHospitalListError?.visibility = View.VISIBLE
                hospitalsListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtHospitalListError?.visibility = View.GONE
                hospitalsListProgressLoad?.visibility = View.GONE
            }
        })
        /*
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
        */
    }
}