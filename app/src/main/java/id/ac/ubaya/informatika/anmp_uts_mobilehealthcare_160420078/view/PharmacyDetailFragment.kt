package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentHospitalDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentPharmacyDetailBinding

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.PharmacyDetailViewModel

import kotlinx.android.synthetic.main.fragment_pharmacy_detail.*


class PharmacyDetailFragment : Fragment() {
    private lateinit var viewModel: PharmacyDetailViewModel
    private lateinit var dataBinding: FragmentPharmacyDetailBinding
    var pharmacyId = ""
    var pharmacyName = ""
    var pharmacyOpeningHour = ""
    var pharmacyAddress = ""
    var pharmacyPhone = ""
    var pharmacyPhotoUrl = ""
    var pharmacyRating = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_doctors_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentPharmacyDetailBinding>(inflater,
            R.layout.fragment_pharmacy_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            pharmacyId = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).id
//            pharmacyName = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyName
//            pharmacyOpeningHour = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyOpeningHour
//            pharmacyAddress = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyAddress
//            pharmacyPhone = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyPhone
//            pharmacyPhotoUrl = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyPhotoUrl
//            pharmacyRating = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyRating
        }
        viewModel = ViewModelProvider(this).get(PharmacyDetailViewModel::class.java)
        viewModel.fetch(pharmacyId.toInt())
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.pharmacyLD.observe(viewLifecycleOwner, Observer {
            dataBinding.pharmacy = it
//            lblPharmacyDetailName.text = it.pharmacyName.toString()
//            lblPharmacyDetailOpeningHour.text = "Jam Buka : " + it.pharmacyOpeningHour.toString()
//            lblPharmacyDetailAlamat.text = "Alamat : " + it.pharmacyAddress.toString()
//            lblPharmacyDetailTelpon.text = "Telepon : " + it.pharmacyPhone.toString()
//            lblPharmacyDetailRating.text = it.pharmacyRating.toString()

            Picasso.get()
                .load(it.pharmacyPhotoUrl)
                .into(imgPharmacyDetail)
        })
    }
}