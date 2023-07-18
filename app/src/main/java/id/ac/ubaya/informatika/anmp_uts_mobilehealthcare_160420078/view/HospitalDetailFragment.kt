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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentDoctorsDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentHospitalDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorDetailViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.HospitalDetailViewModel
import kotlinx.android.synthetic.main.fragment_hospital_detail.*

class HospitalDetailFragment : Fragment() {
    private lateinit var viewModel: HospitalDetailViewModel
    private lateinit var dataBinding: FragmentHospitalDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_hospital_detail, container, false)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HospitalDetailViewModel::class.java)
        var id = HospitalDetailFragmentArgs.fromBundle(requireArguments()).id.toInt()
        viewModel.fetch(id)
        observeViewModel()
        /*
        if(arguments != null) {
            hospitalId = HospitalDetailFragmentArgs.fromBundle(requireArguments()).id
            hospitalName = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalName
            hospitalWebsite = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalWebsite
            hospitalAddress = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalAddress
            hospitalPhone = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalPhone
            hospitalPhotoUrl = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalPhotoUrl
            hospitalRating = HospitalDetailFragmentArgs.fromBundle(requireArguments()).hospitalRating
        }
        */
    }

    private fun observeViewModel() {
        viewModel.hospitalLD.observe(viewLifecycleOwner, Observer {
            dataBinding.hospital = it
            /*
            lblHospitalDetailName.text = it.hospitalName.toString()
            lblHospitalDetailWebsite.text = it.hospitalWebsite.toString()
            lblHospitalDetailAlamat.text = it.hospitalAddress.toString()
            lblHospitalDetailTelpon.text = it.hospitalPhone.toString()
            lblHospitalDetailRating.text = it.hospitalRating.toString()
            Picasso.get()
                .load(it.hospitalPhotoUrl)
                .into(imgHospitalDetail)
            */
        })
    }
}