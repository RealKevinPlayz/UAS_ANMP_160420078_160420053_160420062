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
        var year = 0
        var month = 0
        var day = 0

        var hour = 0
        var minutes = 0

        var date = ""
        var time = ""

        year = (scheduleList[position].date / 31556926)
        month = (scheduleList[position].date-(year * 31556926))/2629743
        day = (scheduleList[position].date-(month * 2629743)-(year * 31556926))/86400

        hour = (scheduleList[position].date-(day * 86400)-(month * 2629743)-(year * 31556926))/3600
        minutes = (scheduleList[position].date-(hour * 3600)-(day * 86400)-(month * 2629743)-(year * 31556926))/60

        year += 1970
        date = "$year - $month - $day."

        time = "$hour : $minutes"

        holder.view.scheduleDate.text = date
        holder.view.scheduleTime.text = time
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