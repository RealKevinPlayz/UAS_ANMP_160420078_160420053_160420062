package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.HospitalDetailViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineDetailViewModel
import kotlinx.android.synthetic.main.fragment_hospital_detail.*
import kotlinx.android.synthetic.main.fragment_medicines_detail.*

class MedicinesDetailFragment : Fragment() {
    private lateinit var viewModel: MedicineDetailViewModel
    var medicineId = ""
    var medicineName = ""
    var medicineDesc = ""
    var medicineDose = ""
    var medicineComposition = ""
    var medicineWarning = ""
    var medicinePhotoUrl = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicines_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            medicineId = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).id
//            medicineName = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicineName
//            medicineDesc = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicineDesc
//            medicineDose = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicineDose
//            medicineComposition = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicineComposition
//            medicineWarning = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicineWarning
//            medicinePhotoUrl = MedicinesDetailFragmentArgs.fromBundle(requireArguments()).medicinePhotoUrl
        }
        viewModel = ViewModelProvider(this).get(MedicineDetailViewModel::class.java)
        viewModel.fetch(medicineId.toInt())
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.medicineLD.observe(viewLifecycleOwner, Observer {
            lblMedicineDetailName.text = it.medicineName.toString()
            lblMedicineDetailDescription.text = "Manfaat : " + it.medicineDesc.toString()
            lblMedicineDetailDose.text = "Rekomendasi Dosis : " + it.medicineDose.toString()
            lblMedicineDetailComposition.text = "Komposisi : " + it.medicineComposition.toString()
            lblMedicineDetailWarning.text = "Efek Samping : " + it.medicineWarning.toString()

            Picasso.get()
                .load(it.medicinePhotoUrl)
                .into(imgMedicineDetail)
        })
    }
}