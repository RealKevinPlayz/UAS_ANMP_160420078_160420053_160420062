package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorDetailViewModel
import kotlinx.android.synthetic.main.fragment_doctors_detail.*

class DoctorsDetailFragment : Fragment() {
    private lateinit var viewModel: DoctorDetailViewModel
    var doctorId = ""
    var doctorName = ""
    var doctorSpecialty = ""
    var doctorAddress = ""
    var doctorPhone = ""
    var doctorPhotoUrl = ""
    var doctorRating = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctors_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            doctorId = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).id
            doctorName = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorName
            doctorSpecialty = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorSpecialty
            doctorAddress = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorAddress
            doctorPhone = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorPhone
            doctorPhotoUrl = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorPhotoUrl
            doctorRating = DoctorsDetailFragmentArgs.fromBundle(requireArguments()).doctorRating
        }
        viewModel = ViewModelProvider(this).get(DoctorDetailViewModel::class.java)
        viewModel.fetch(doctorId, doctorName, doctorSpecialty, doctorAddress, doctorPhone, doctorPhotoUrl, doctorRating)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.doctorLD.observe(viewLifecycleOwner, Observer {
            lblDoctorDetailName.text = it.doctorName.toString()
            lblDoctorDetailSpeciality.text = it.doctorSpecialty.toString()
            lblDoctorDetailAlamat.text = "Alamat Praktek : " + it.doctorAddress.toString()
            lblDoctorDetailTelpon.text = "Telepon : " + it.doctorPhone.toString()
            lblDoctorDetailRating.text = it.doctorRating.toString()

            Picasso.get()
                .load(it.doctorPhotoUrl)
                .into(imgDoctorsDetail)
        })
    }

}