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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.PharmacyListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*

import kotlinx.android.synthetic.main.fragment_hospital_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_pharmacy_list.*

class PharmacyListFragment : Fragment() {
    private lateinit var viewModel: PharmacyListViewModel
    private val pharmacylListAdapter = PharmacyListAdapter(arrayListOf(), { item -> viewModel.clearTaskPharmacy(item) })

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
        viewModel.refreshPharmacy()
        pharmaciesRecView.layoutManager = LinearLayoutManager(context)
        pharmaciesRecView.adapter = pharmacylListAdapter

        refreshLayout.setOnRefreshListener {
            pharmaciesRecView.visibility = View.GONE
            txtPharmacyListError.visibility = View.GONE
            pharmaciesListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshPharmacy()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
        /*
        var pharmacy1 = Pharmacy("Mediplus Pharmacy", "09:00 - 18:00", "123 Main St, Anytown USA", "+1-555-123-4567", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Medplus_pharmacy.jpg/2560px-Medplus_pharmacy.jpg", "4.5")
        var pharmacy2 = Pharmacy("Green Cross Pharmacy", "08:00 - 20:00", "456 Broad St, Anytown USA", "+1-555-987-6543", "https://c.yell.com/t_galleryFit,f_auto/d4afcc9e-cdc4-4e7d-90c1-016fc7c6383f_image_jpeg.jpg", "4.2")
        var pharmacy3 = Pharmacy("Cornerstone Pharmacy", "10:00 - 19:00", "789 Oak St, Anytown USA", "+1-555-234-5678", "https://static.spacecrafted.com/bc231dd8ea9f466babf3c6231d703d5c/i/dcd9093e11c54aa48d4e10c47cc33e63/1/4SoifmQpDrHbZJ6W5XJrp/Screen%20Shot%202018-02-27%20at%201.00.49%20PM.png", "4.9")
        var pharmacy4 = Pharmacy("Wellness Pharmacy", "08:30 - 21:00", "147 Pine St, Anytown USA", "+1-555-876-5432", "https://content.jdmagicbox.com/comp/pune/v7/020pxx20.xx20.200424201005.l9v7/catalogue/wellness-pharmacy-and-beauty-centre-ravet-pune-chemists-x322lpzb0o.jpg", "4.7")
        viewModel.addPharmacy(pharmacy1)
        viewModel.addPharmacy(pharmacy2)
        viewModel.addPharmacy(pharmacy3)
        viewModel.addPharmacy(pharmacy4)
        */
    }

    fun observeViewModel() {
        viewModel.pharmacyLD.observe(viewLifecycleOwner, Observer {
            pharmacylListAdapter.updatePharmacyList(it)
            if (it.isEmpty()){
                txtPharmacyListError?.visibility = View.VISIBLE
                pharmaciesListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtPharmacyListError?.visibility = View.GONE
                pharmaciesListProgressLoad?.visibility = View.GONE
            }
        })
        /*
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
        */
    }
}