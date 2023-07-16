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

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.PharmacyDetailViewModel

import kotlinx.android.synthetic.main.fragment_pharmacy_detail.*


class PharmacyDetailFragment : Fragment() {
    private lateinit var viewModel: PharmacyDetailViewModel
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
        return inflater.inflate(R.layout.fragment_pharmacy_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            pharmacyId = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).id
            pharmacyName = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyName
            pharmacyOpeningHour = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyOpeningHour
            pharmacyAddress = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyAddress
            pharmacyPhone = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyPhone
            pharmacyPhotoUrl = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyPhotoUrl
            pharmacyRating = PharmacyDetailFragmentArgs.fromBundle(requireArguments()).pharmacyRating
        }
        viewModel = ViewModelProvider(this).get(PharmacyDetailViewModel::class.java)
        viewModel.fetch(pharmacyName, pharmacyOpeningHour, pharmacyAddress, pharmacyPhone, pharmacyPhotoUrl, pharmacyRating)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.pharmacyLD.observe(viewLifecycleOwner, Observer {
            lblPharmacyDetailName.text = it.pharmacyName.toString()
            lblPharmacyDetailOpeningHour.text = "Jam Buka : " + it.pharmacyOpeningHour.toString()
            lblPharmacyDetailAlamat.text = "Alamat : " + it.pharmacyAddress.toString()
            lblPharmacyDetailTelpon.text = "Telepon : " + it.pharmacyPhone.toString()
            lblPharmacyDetailRating.text = it.pharmacyRating.toString()

            Picasso.get()
                .load(it.pharmacyPhotoUrl)
                .into(imgPharmacyDetail)
        })
    }
}