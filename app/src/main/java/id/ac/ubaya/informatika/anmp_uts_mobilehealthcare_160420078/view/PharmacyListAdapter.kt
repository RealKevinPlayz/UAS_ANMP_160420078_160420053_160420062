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

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage

import kotlinx.android.synthetic.main.hospital_list_item.view.*
import kotlinx.android.synthetic.main.pharmacy_list_item.view.*

var pharmacyList = null

class PharmacyListAdapter(val pharmacyList:ArrayList<Pharmacy>)
    : RecyclerView.Adapter<PharmacyListAdapter.PharmacyViewHolder>() {
    class PharmacyViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PharmacyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.pharmacy_list_item, parent, false)
            return PharmacyViewHolder(view)

    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        var imageView = holder.view.findViewById<ImageView>(R.id.pharmacyCardImage)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.pharmacyCardProgressBar)
        imageView.loadImage(pharmacyList[position].pharmacyPhotoUrl, progressBar)

        holder.view.lblPharmacyCardName.text = pharmacyList[position].pharmacyName
        holder.view.lblPharmacyCardRating.text = pharmacyList[position].pharmacyRating
        holder.view.btnPharmacyDetail.setOnClickListener {
            val pharmacyId = pharmacyList[position].pharmacyId.toString()
            val pharmacyName = pharmacyList[position].pharmacyName.toString()
            val pharmacyOpeningHour = pharmacyList[position].pharmacyOpeningHour.toString()
            val pharmacyAddress = pharmacyList[position].pharmacyAddress.toString()
            val pharmacyPhone = pharmacyList[position].pharmacyPhone.toString()
            val pharmacyPhotoUrl = pharmacyList[position].pharmacyPhotoUrl.toString()
            val pharmacyRating = pharmacyList[position].pharmacyRating.toString()
            val action = PharmacyListFragmentDirections.actionPharmacyDetail(pharmacyId, pharmacyName, pharmacyOpeningHour,
                pharmacyAddress, pharmacyPhone, pharmacyPhotoUrl, pharmacyRating)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updatePharmacyList(newPharmacyList: ArrayList<Pharmacy>) {
        pharmacyList.clear()
        pharmacyList.addAll(newPharmacyList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return pharmacyList.size
    }


}
