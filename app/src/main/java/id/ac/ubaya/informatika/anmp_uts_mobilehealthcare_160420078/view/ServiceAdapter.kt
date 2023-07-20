package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FacilityListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ServiceListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Article
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Facility
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Service

class ServiceAdapter(var serviceList:ArrayList<Service>) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    class ServiceViewHolder(var view: ServiceListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = ServiceListItemBinding.inflate(inflater, parent, false)
        return ServiceAdapter.ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.view.service = serviceList[position]
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    fun updateServiceList(newServiceList: List<Service>) {
        serviceList.clear()
        serviceList.addAll(newServiceList)
        notifyDataSetChanged()
    }
}