package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.MedicineListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.PharmacyListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Pharmacy
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage

import kotlinx.android.synthetic.main.hospital_list_item.view.*
import kotlinx.android.synthetic.main.pharmacy_list_item.view.*

class PharmacyListAdapter(var pharmacyList:ArrayList<Pharmacy>, var adapterOnClick : (Pharmacy) -> Unit) : RecyclerView.Adapter<PharmacyListAdapter.PharmacyViewHolder>() ,
    ButtonDetailLayoutInterface{
    class PharmacyViewHolder (var view: PharmacyListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PharmacyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            //val view = inflater.inflate(R.layout.pharmacy_list_item, parent, false)
            var view = PharmacyListItemBinding.inflate(inflater, parent, false)
            return PharmacyViewHolder(view)

    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.view.pharmacy = pharmacyList[position]
        holder.view.btnListener = this
        /*
        var imageView = holder.view.findViewById<ImageView>(R.id.pharmacyCardImage)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.pharmacyCardProgressBar)
        imageView.loadImage(pharmacyList[position].pharmacyPhotoUrl, progressBar)

        holder.view.lblPharmacyCardName.text = pharmacyList[position].pharmacyName
        holder.view.lblPharmacyCardRating.text = pharmacyList[position].pharmacyRating
        holder.view.btnPharmacyDetail.setOnClickListener {
            val pharmacyName = pharmacyList[position].pharmacyName.toString()
            val pharmacyOpeningHour = pharmacyList[position].pharmacyOpeningHour.toString()
            val pharmacyAddress = pharmacyList[position].pharmacyAddress.toString()
            val pharmacyPhone = pharmacyList[position].pharmacyPhone.toString()
            val pharmacyPhotoUrl = pharmacyList[position].pharmacyPhotoUrl.toString()
            val pharmacyRating = pharmacyList[position].pharmacyRating.toString()
            //val action = PharmacyListFragmentDirections.actionPharmacyDetail(pharmacyId, pharmacyName, pharmacyOpeningHour, pharmacyAddress, pharmacyPhone, pharmacyPhotoUrl, pharmacyRating)
            //Navigation.findNavController(it).navigate(action)
        }
        */
    }
    fun updatePharmacyList(newPharmacyList: List<Pharmacy>) {
        pharmacyList.clear()
        pharmacyList.addAll(newPharmacyList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return pharmacyList.size
    }


}
