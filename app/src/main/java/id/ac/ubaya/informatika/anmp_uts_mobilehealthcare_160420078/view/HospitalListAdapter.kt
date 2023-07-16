package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.HospitalListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.MedicineListItemBinding

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Medicine
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage

import kotlinx.android.synthetic.main.hospital_list_item.view.*

class HospitalListAdapter(var hospitalList:ArrayList<Hospital>, var adapterOnClick : (Hospital) -> Unit) : RecyclerView.Adapter<HospitalListAdapter.HospitalViewHolder>() {
    class HospitalViewHolder (var view: HospitalListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        HospitalViewHolder {
            var inflater = LayoutInflater.from(parent.context)
            //var view = inflater.inflate(R.layout.hospital_list_item, parent, false)
            var view = HospitalListItemBinding.inflate(inflater, parent, false)
            return HospitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.view.hospital = hospitalList[position]
        /*
        var imageView = holder.view.findViewById<ImageView>(R.id.hospitalCardImage)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.hospitalCardProgressBar)
        imageView.loadImage(hospitalList[position].hospitalPhotoUrl, progressBar)
        holder.view.lblHospitalCardName.text = hospitalList[position].hospitalName
        holder.view.lblHospitalCardRating.text = hospitalList[position].hospitalRating
        holder.view.btnHospitalDetail.setOnClickListener {
            val hospitalName = hospitalList[position].hospitalName.toString()
            val hospitalWebsite = hospitalList[position].hospitalWebsite.toString()
            val hospitalAddress = hospitalList[position].hospitalAddress.toString()
            val hospitalPhone = hospitalList[position].hospitalPhone.toString()
            val hospitalPhotoUrl = hospitalList[position].hospitalPhotoUrl.toString()
            val hospitalRating = hospitalList[position].hospitalRating.toString()
            //val action = HospitalListFragmentDirections.actionHospitalDetail(hospitalId, hospitalName, hospitalWebsite, hospitalAddress, hospitalPhone, hospitalPhotoUrl, hospitalRating)
            //Navigation.findNavController(it).navigate(action)
        }
        */
    }
    fun updateHospitalList(newHospitalList: List<Hospital>) {
        hospitalList.clear()
        hospitalList.addAll(newHospitalList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return hospitalList.size
    }


}
