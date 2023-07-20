package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.ScheduleListItemBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Hospital
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Schedule
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleListAdapter(var scheduleList:ArrayList<Schedule>) : RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(var view: ScheduleListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = ScheduleListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.view.schedule = scheduleList[position]

        var date = ""
        var time = ""

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateLong = Date(scheduleList[position].date.toLong() * 1000)

        val timeFormat = SimpleDateFormat("hh:mm")
        val timeLong = Date(scheduleList[position].date.toLong() * 1000)

        date = dateFormat.format(dateLong).toString()
        time = timeFormat.format(timeLong).toString()

        holder.view.scheduleDate.text = date
        holder.view.scheduleTime.text = time
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