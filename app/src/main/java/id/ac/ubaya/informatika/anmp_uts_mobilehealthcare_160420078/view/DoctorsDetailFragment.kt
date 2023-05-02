package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.DoctorDetailViewModel

class DoctorsDetailFragment : Fragment() {
    private lateinit var viewModel: DoctorDetailViewModel
    var doctorId = ""
    var doctorName = ""
    var doctorSpecialty = ""
    var doctorAddress = ""
    var doctorPhone = ""
    var doctorPhotoUrl = ""
    var doctorRating = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctors_detail, container, false)
    }

}