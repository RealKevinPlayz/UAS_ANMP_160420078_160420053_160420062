package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ScheduleListItemBinding
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
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

}