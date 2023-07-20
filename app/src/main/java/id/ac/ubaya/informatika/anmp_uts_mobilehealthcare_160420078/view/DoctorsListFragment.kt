package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*
import kotlinx.android.synthetic.main.fragment_doctors_list.refreshLayout

class DoctorsListFragment : Fragment() {
    private lateinit var viewModel: DoctorListViewModel
    private val doctorListAdapter = DoctorsListAdapter(arrayListOf())

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
        viewModel.refreshDoctor()
        doctorsRecView.layoutManager = LinearLayoutManager(context)
        doctorsRecView.adapter = doctorListAdapter

        refreshLayout.setOnRefreshListener {
            doctorsRecView.visibility = View.GONE
            txtDoctorListError.visibility = View.GONE
            doctorsListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshDoctor()
            refreshLayout.isRefreshing = false
        }

        fabSchedule.setOnClickListener {
            var action = DoctorsListFragmentDirections.actionScheduleList()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
        /*
        var doctor1 = Doctor("dr. Prettysun Ang Mellow, Sp.PD", "Dokter Penyakit Dalam", "Rumah Sakit Mitra Keluarga Kenjeran, Jl. Kenjeran No.506, Kalijudan, Mulyorejo, Kota Surabaya, Jawa Timur 60134, Indonesia", "3724-0951-8135", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1552352865/image_doctor/prettysun.jpg.jpg", "5")
        var doctor2 = Doctor("dr. Andry Sultana, Sp.PD, FINASIM", "Dokter Penyakit Dalam", "Mayapada Hospital Surabaya, Jl. Mayjen Sungkono No.20, Pakis, Kec. Sawahan, Kota Surabaya, Jawa Timur 60256", "8210-3956-4722", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1639018087/image_doctor/dr.%20Andry%20Sultana%2C%20Sp.PD.jpg.jpg", "4")
        var doctor3 = Doctor("dr. Dimple Gobind Nagrani, Sp.A", "Dokter Anak", "Jl. Teuku Cik Ditiro No.28 Menteng Jakarta Pusat, Menteng, RT.9/RW.2, Gondangdia, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10350, Indonesia", "3057-1849-3216", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1584974182/image_doctor/dr.%20Dimple%20Gobind%20Nagrani%2C%20Sp.A.jpg.jpg", "4")
        var doctor4 = Doctor("dr. Bambang Herwanto, Sp.JP, FIHA", "Dokter Penyakit Jantung", "Rumah Sakit Umum Siloam, Jl. Raya Gubeng No.70, Gubeng, Kota SBY, Jawa Timur 60281, Indonesia", "8315-0962-6721", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_60,h_60,c_fill,dpr_2.0/v1500451269/image_doctor/Bambang%20Herwanto%2C%20dr.%2C%20SpJP%20%28K%29%2C%20FIHA.JPG.jpg", "5")
        var doctor5 = Doctor("dr. Ivana Sugiarto, M.Biomed, Sp.KK", "Dokter Kulit", "Mitra Keluarga Kenjeran, Jl. Kenjeran No.506, Kalijudan, Mulyorejo, Kota Surabaya, Jawa Timur 60134, Indonesia", "2963-1582-2148", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_60,h_60,c_fill,dpr_2.0/v1607570785/image_doctor/unnamed%20%284%29%20-%20Pita%20Patimah.jpg.jpg", "4")
        viewModel.addDoctor(doctor1)
        viewModel.addDoctor(doctor2)
        viewModel.addDoctor(doctor3)
        viewModel.addDoctor(doctor4)
        viewModel.addDoctor(doctor5)
        */
    }

    private fun observeViewModel() {
        viewModel.doctorLD.observe(viewLifecycleOwner, Observer {
            doctorListAdapter.updateDoctorList(it)
            if (it.isEmpty()){
                txtDoctorListError?.visibility = View.VISIBLE
                doctorsListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtDoctorListError?.visibility = View.GONE
                doctorsListProgressLoad?.visibility = View.GONE
            }
        })
        /*
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
        */
    }
}