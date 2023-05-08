package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Doctor
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage
import kotlinx.android.synthetic.main.doctors_list_item.view.*

var doctorList = null

class DoctorListAdapter(val doctorList:ArrayList<Doctor>)
    : RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {
    class DoctorViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        DoctorViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.doctors_list_item, parent, false)
            return DoctorViewHolder(view)

    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        var imageView = holder.view.findViewById<ImageView>(R.id.doctorCardImage)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.doctorCardProgressBar)
        imageView.loadImage(doctorList[position].doctorPhotoUrl, progressBar)

        holder.view.txtDoctorsListName.text = doctorList[position].doctorName
        holder.view.txtDoctorsSpecialty.text = doctorList[position].doctorSpecialty
        holder.view.txtDoctorsListRating.text = doctorList[position].doctorRating
        holder.view.btnDoctorDetail.setOnClickListener {
            val doctorId = doctorList[position].id.toString()
            val doctorName = doctorList[position].doctorName.toString()
            val doctorSpecialty = doctorList[position].doctorSpecialty.toString()
            val doctorAddress = doctorList[position].doctorAddress.toString()
            val doctorPhone = doctorList[position].doctorPhone.toString()
            val doctorPhotoUrl = doctorList[position].doctorPhotoUrl.toString()
            val doctorRating = doctorList[position].doctorRating.toString()
            val action = DoctorsListFragmentDirections.actionDoctorDetail(doctorId, doctorName, doctorSpecialty,
                doctorAddress, doctorPhone, doctorPhotoUrl, doctorRating)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateDoctorList(newDoctorList: ArrayList<Doctor>) {
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return doctorList.size
    }


}
