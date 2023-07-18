package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.DoctorsListItemBinding

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage
import kotlinx.android.synthetic.main.doctors_list_item.view.*

class DoctorListAdapter(var doctorList:ArrayList<Doctor>, var adapterOnClick : (Doctor) -> Unit) : RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {
    class DoctorViewHolder (var view: DoctorsListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.doctors_list_item, parent, false)
        var view = DoctorsListItemBinding.inflate(inflater, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.view.doctor = doctorList[position]
        //var imageView = holder.view.findViewById<ImageView>(R.id.doctorCardImage)
        //var progressBar = holder.view.findViewById<ProgressBar>(R.id.doctorCardProgressBar)
        //imageView.loadImage(doctorList[position].doctorPhotoUrl, progressBar)

        //holder.view.txtDoctorsListName.text = doctorList[position].doctorName
        //holder.view.txtDoctorsSpecialty.text = doctorList[position].doctorSpecialty
        //holder.view.txtDoctorsListRating.text = doctorList[position].doctorRating.toString()
        /*
        holder.view.btnDoctorDetail.setOnClickListener {
            val doctorId = doctorList[position].id.toString()
            val doctorName = doctorList[position].doctorName.toString()
            val doctorSpecialty = doctorList[position].doctorSpecialty.toString()
            val doctorAddress = doctorList[position].doctorAddress.toString()
            val doctorPhone = doctorList[position].doctorPhone.toString()
            val doctorPhotoUrl = doctorList[position].doctorPhotoUrl.toString()
            val doctorRating = doctorList[position].doctorRating
            val action = doctorRating?.let { it1 ->
                DoctorsListFragmentDirections.actionDoctorDetail(doctorId, doctorName, doctorSpecialty,
                    doctorAddress, doctorPhone, doctorPhotoUrl,
                    it1
                )
            }
            if (action != null) {
                Navigation.findNavController(it).navigate(action)
            }
        }
        */
    }



    override fun getItemCount(): Int {
        return doctorList.size
    }

    fun updateDoctorList(newDoctorList: List<Doctor>) {
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }
}
