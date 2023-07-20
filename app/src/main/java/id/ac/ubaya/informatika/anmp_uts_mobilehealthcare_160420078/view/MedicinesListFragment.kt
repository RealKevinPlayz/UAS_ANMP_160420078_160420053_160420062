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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Medicine

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineListViewModel
import kotlinx.android.synthetic.main.fragment_doctors_list.*

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
        viewModel.refreshMedicine()
        medicinesRecView.layoutManager = LinearLayoutManager(context)
        medicinesRecView.adapter = medicineListAdapter

        refreshLayout.setOnRefreshListener {
            medicinesRecView.visibility = View.GONE
            txtMedicineListError.visibility = View.GONE
            medicinesListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshMedicine()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
        /*
        var medicine1 = Medicine("Amoxicillin", "Mengatasi infeksi bakteri, termasuk gonore, otitis media, atau infeksi ginjal (pielonefritis)", "Dewasa dan anak dengan BB ≥40 kg: 250–500 mg, tiap 8 jam atau 500–1.000 mg, tiap 12 jam. Untuk infeksi berat dosisnya adalah 750–1.000 mg, tiap 8 jam.", "-", "Dapat menyebabkan perubahan rasa pada lidah, mual atau muntah, sakit kepala, diare, dan ruam", "https://images.k24klik.com/product/large/apotek_online_k24klik_20211223092009359225_AMOXICILLIN-KF-500MG-TAB-100S-removebg-preview.png")
        var medicine2 = Medicine("Betadine", "Obat pertolongan pertama yang digunakan untuk mencegah dan mengobati infeksi pada luka", "Oleskan ke kulit sesuai kebutuhan.", "-", "Dapat menyebabkan gatal, ruam, bengkak pada kulit, nyeri pada vagina, iritasi pada kulit, mulut, atau bagian tubuh yang terkena Betadine.", "https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/14381/14381_1624258523.7964.jpg")
        var medicine3 = Medicine("Dopamine", "Membantu kerja jantung dalam memompa darah saat terjadi syok", "Dosis awal dopamin suntik adalah 2–5 mcg/kgBB per menit yang diberikan melalui infus", "-", "Denyut jantung tidak teratur atau jantung berdebar, pusing yang berat hingga ingin pingsan, sesak napas, dan nyeri dada", "https://www.pyfa.co.id/wp-content/uploads/2022/07/Dopamine-isi-50.jpg")
        var medicine4 = Medicine("Mefinal", "Obat ini dapat digunakan untuk Nyeri pada kondisi rematik, cedera jaringan lunak, kondisi muskuloskeletal menyakitkan lainnya, dismenorea, sakit kepala, sakit gigi, nyeri pasca operasi", "Dewasa dan anak > 14 tahun : 3 x sehari 500 mg", "-", "Ggn & perdarahan GI, tukak peptik", "https://d2qjkwm11akmwu.cloudfront.net/products/4969-1665771575.webp")
        var medicine5 = Medicine("Lodia", "Obat ini dapat digunakan untuk mengobati diare akut dan kronis", "2 tab, diikuti 1 tab setelah setiap tinja yang tidak berbentuk. Diare kronis 2-4 tab/hari dalam dosis terbagi. Maks: 8 tab setiap hari", "-", "Sakit perut, megakolon toksik, pusing, kelelahan, ruam kulit", "https://d2qjkwm11akmwu.cloudfront.net/products/289-1.webp")
        viewModel.addMedicine(medicine1)
        viewModel.addMedicine(medicine2)
        viewModel.addMedicine(medicine3)
        viewModel.addMedicine(medicine4)
        viewModel.addMedicine(medicine5)
        */
    }

    fun observeViewModel() {
        viewModel.medicineLD.observe(viewLifecycleOwner, Observer {
            medicineListAdapter.updateMedicineList(it)
            if (it.isEmpty()){
                txtMedicineListError?.visibility = View.VISIBLE
                medicinesListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtMedicineListError?.visibility = View.GONE
                medicinesListProgressLoad?.visibility = View.GONE
            }
        })
        /*
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
        */
    }
}