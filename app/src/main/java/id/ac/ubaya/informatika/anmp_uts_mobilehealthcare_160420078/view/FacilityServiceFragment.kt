package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Facility
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Service
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.ArticleListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.FacilityListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.ServiceListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*
import kotlinx.android.synthetic.main.fragment_facility_service.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.refreshLayout

class FacilityServiceFragment : Fragment() {
    private lateinit var viewModelFacility: FacilityListViewModel
    private lateinit var viewModelService: ServiceListViewModel
    private var facilityListAdapter = FacilityAdapter(arrayListOf())
    private var serviceListAdapter = ServiceAdapter(arrayListOf())
    var hospitalID = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facility_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
        var shared = this.requireActivity()
            .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        hospitalID = shared.getInt("hospitalID", 0)
        viewModelFacility = ViewModelProvider(this).get(FacilityListViewModel::class.java)
        viewModelService = ViewModelProvider(this).get(ServiceListViewModel::class.java)
        viewModelFacility.refreshFacility(hospitalID)
        viewModelService.refreshService(hospitalID)
        facilitiesRecView.layoutManager = LinearLayoutManager(context)
        serviceRecView.layoutManager = LinearLayoutManager(context)
        facilitiesRecView.adapter = facilityListAdapter
        serviceRecView.adapter = serviceListAdapter
        refreshLayout.setOnRefreshListener {
            facilitiesRecView.visibility = View.GONE
            serviceRecView.visibility = View.GONE
            txtFacilityListError.visibility = View.GONE
            txtServiceListError.visibility = View.GONE
            facilitiesListProgressLoad.visibility = View.VISIBLE
            serviceListProgressLoad.visibility = View.VISIBLE
            viewModelFacility.refreshFacility(hospitalID)
            viewModelService.refreshService(hospitalID)
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
        /*
        var facility1 = Facility(1, "Tempat Parkir")
        var facility2 = Facility(2, "Mushola")
        var facility3 = Facility(3, "Lift")
        var facility4 = Facility(4, "Taman")
        var facility5 = Facility(1, "Mushola")
        var facility6 = Facility(2, "Ruang Tunggu")
        var facility7 = Facility(3, "Tempat Parkir")
        var facility8 = Facility(4, "ATM")
        var facility9 = Facility(1, "Cafetaria")
        var facility10 = Facility(2, "Optik")
        var facility11 = Facility(3, "Taman")
        var facility12 = Facility(4, "Ruang Tunggu")
        var facility13 = Facility(1, "Ruang Main Anak")
        var facility14 = Facility(2, "Bank")
        var facility15 = Facility(3, "Gym")
        var facility16 = Facility(4, "Lift")

        viewModelFacility.addFacility(facility1)
        viewModelFacility.addFacility(facility2)
        viewModelFacility.addFacility(facility3)
        viewModelFacility.addFacility(facility4)
        viewModelFacility.addFacility(facility5)
        viewModelFacility.addFacility(facility6)
        viewModelFacility.addFacility(facility7)
        viewModelFacility.addFacility(facility8)
        viewModelFacility.addFacility(facility9)
        viewModelFacility.addFacility(facility10)
        viewModelFacility.addFacility(facility11)
        viewModelFacility.addFacility(facility12)
        viewModelFacility.addFacility(facility13)
        viewModelFacility.addFacility(facility14)
        viewModelFacility.addFacility(facility15)
        viewModelFacility.addFacility(facility16)

        var service1 = Service(1, "Pelayanan Medis")
        var service2 = Service(2, "Pelayanan Gawat Darurat")
        var service3 = Service(3, "Farmasi")
        var service4 = Service(4, "Laboratorium")
        var service5 = Service(1, "Pemeriksaan dan Diagnosis")
        var service6 = Service(2, "Rawat Inap")
        var service7 = Service(3, "Pelayanan Gawat Darurat")
        var service8 = Service(4, "Pembedahan")
        var service9 = Service(1, "Pelayanan Rawat Jalan")
        var service10 = Service(2, "Perawatan Kanker")
        var service11 = Service(3, "Pelayanan Kesehatan Mental")
        var service12 = Service(4, "Rehabilitasi")
        var service13 = Service(1, "Kamar Bersalin")
        var service14 = Service(2, "Pemeriksaan Medis")
        var service15 = Service(3, "Pelayanan Kesehatan Anak")
        var service16 = Service(4, "Layanan Gizi")

        viewModelService.addService(service1)
        viewModelService.addService(service2)
        viewModelService.addService(service3)
        viewModelService.addService(service4)
        viewModelService.addService(service5)
        viewModelService.addService(service6)
        viewModelService.addService(service7)
        viewModelService.addService(service8)
        viewModelService.addService(service9)
        viewModelService.addService(service10)
        viewModelService.addService(service11)
        viewModelService.addService(service12)
        viewModelService.addService(service13)
        viewModelService.addService(service14)
        viewModelService.addService(service15)
        viewModelService.addService(service16)
        */
    }
    private fun observeViewModel(){
        viewModelFacility.facilityLD.observe(viewLifecycleOwner, Observer {
            facilityListAdapter.updateFacilityList(it)
            if (it.isEmpty()){
                txtFacilityListError?.visibility = View.VISIBLE
                facilitiesListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtFacilityListError?.visibility = View.GONE
                facilitiesListProgressLoad?.visibility = View.GONE
            }
        })
        viewModelService.serviceLD.observe(viewLifecycleOwner, Observer {
            serviceListAdapter.updateServiceList(it)
            if (it.isEmpty()){
                txtServiceListError?.visibility = View.VISIBLE
                serviceListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtServiceListError?.visibility = View.GONE
                serviceListProgressLoad?.visibility = View.GONE
            }
        })
    }
}