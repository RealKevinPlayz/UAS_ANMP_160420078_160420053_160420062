package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ScheduleListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Schedule

class ScheduleListAdapter(var scheduleList:ArrayList<Schedule>) : RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(var view: ScheduleListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = ScheduleListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.view.schedule = scheduleList[position]
        Log.wtf("Schedule Data id", scheduleList[position].id.toString())
        Log.wtf("Schedule Data doctor name", scheduleList[position].doctor_name.toString())
    }

    fun updateScheduleList(newScheduleList: List<Schedule>) {
        scheduleList.clear()
        scheduleList.addAll(newScheduleList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

}