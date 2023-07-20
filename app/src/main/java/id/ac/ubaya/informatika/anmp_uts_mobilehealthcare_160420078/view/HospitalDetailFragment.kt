package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Context
import android.content.SharedPreferences
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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentDoctorsDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentHospitalDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.HospitalDetailViewModel
import kotlinx.android.synthetic.main.fragment_hospital_detail.*

class HospitalDetailFragment : Fragment(), ServiceFacilityLayoutInterface {
    private lateinit var viewModel: HospitalDetailViewModel
    private lateinit var dataBinding: FragmentHospitalDetailBinding
    var hospitalId = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_doctors_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentHospitalDetailBinding>(inflater,
            R.layout.fragment_hospital_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            hospitalId = HospitalDetailFragmentArgs.fromBundle(requireArguments()).id
//            hospitalName = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalName
//            hospitalWebsite = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalWebsite
//            hospitalAddress = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalAddress
//            hospitalPhone = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalPhone
//            hospitalPhotoUrl = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalPhotoUrl
//            hospitalRating = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalRating
            dataBinding.facilityservicelistener = this
            var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
            var shared = this.requireActivity()
                .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor = shared.edit();
            editor.putInt("hospitalID", hospitalId.toInt());
            editor.apply();
        }
        viewModel = ViewModelProvider(this).get(HospitalDetailViewModel::class.java)
        viewModel.fetch(hospitalId.toInt())
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.hospitalLD.observe(viewLifecycleOwner, Observer {
            dataBinding.hospital = it
//            lblHospitalDetailName.text = it.hospitalName.toString()
//            lblHospitalDetailWebsite.text = it.hospitalWebsite.toString()
//            lblHospitalDetailAlamat.text = it.hospitalAddress.toString()
//            lblHospitalDetailTelpon.text = it.hospitalPhone.toString()
//            lblHospitalDetailRating.text = it.hospitalRating.toString()

            Picasso.get()
                .load(it.hospitalPhotoUrl)
                .into(imgHospitalDetail)
        })
    }
}