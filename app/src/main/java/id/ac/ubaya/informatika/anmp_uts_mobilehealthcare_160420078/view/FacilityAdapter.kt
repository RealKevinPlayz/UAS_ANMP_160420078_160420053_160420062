package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ArticleListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FacilityListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ServiceListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Facility
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Service

class FacilityAdapter(var facilityList:ArrayList<Facility>) : RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>() {
    class FacilityViewHolder(var view: FacilityListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = FacilityListItemBinding.inflate(inflater, parent, false)
        return FacilityAdapter.FacilityViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        holder.view.facility = facilityList[position]
    }

    override fun getItemCount(): Int {
        return facilityList.size
    }

    fun updateFacilityList(newFacilityList: List<Facility>) {
        facilityList.clear()
        facilityList.addAll(newFacilityList)
        notifyDataSetChanged()
    }
}