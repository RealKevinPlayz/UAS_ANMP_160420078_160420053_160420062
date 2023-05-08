package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Medicine
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.loadImage

import kotlinx.android.synthetic.main.medicine_list_item.view.*

var medicineList = null

class MedicineListAdapter(val medicineList:ArrayList<Medicine>)
    : RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {
    class MedicineViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MedicineViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.medicine_list_item, parent, false)
            return MedicineViewHolder(view)

    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        var imageView = holder.view.findViewById<ImageView>(R.id.medicineCardImage)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.medicineCardProgressBar)
        imageView.loadImage(medicineList[position].medicinePhotoUrl, progressBar)

        holder.view.txtMedicineListName.text = medicineList[position].medicineName
        holder.view.txtMedicineDesc.text = medicineList[position].medicineDesc
        holder.view.btnMedicineDetail.setOnClickListener {
            val medicineId = medicineList[position].medicineId.toString()
            val medicineName = medicineList[position].medicineName.toString()
            val medicineDesc = medicineList[position].medicineDesc.toString()
            val medicineDose = medicineList[position].medicineDose.toString()
            val medicineComposition = medicineList[position].medicineComposition.toString()
            val medicineWarning = medicineList[position].medicineWarning.toString()
            val medicinePhotoUrl = medicineList[position].medicinePhotoUrl.toString()
            val action = MedicinesListFragmentDirections.actionMedicineDetail(medicineId, medicineName, medicineDesc,
                medicineDose, medicineComposition, medicineWarning, medicinePhotoUrl)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateMedicineList(newMedicineList: ArrayList<Medicine>) {
        medicineList.clear()
        medicineList.addAll(newMedicineList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return medicineList.size
    }


}
