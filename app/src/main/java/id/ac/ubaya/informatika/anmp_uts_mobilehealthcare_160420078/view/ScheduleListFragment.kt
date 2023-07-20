package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineListViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.ScheduleListViewModel
import kotlinx.android.synthetic.main.fragment_hospital_list.*
import kotlinx.android.synthetic.main.fragment_medicines_list.*
import kotlinx.android.synthetic.main.fragment_medicines_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_schedule_list.*

class ScheduleListFragment : Fragment() {
    private lateinit var viewModel: ScheduleListViewModel
    private var scheduleListAdapter = ScheduleListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
        var shared = this.requireActivity()
            .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        var userID = shared.getInt("userID", 0)
        viewModel = ViewModelProvider(this).get(ScheduleListViewModel::class.java)
        viewModel.refreshSchedule(userID)
        scheduleRecView.layoutManager = LinearLayoutManager(context)
        scheduleRecView.adapter = scheduleListAdapter

        refreshLayout.setOnRefreshListener {
            Log.wtf("Refresh Schedule", "success")
            scheduleRecView.visibility = View.GONE
            txtScheduleListError.visibility = View.GONE
            scheduleListProgressLoad.visibility = View.VISIBLE
            viewModel.refreshSchedule(userID)
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.scheduleLD.observe(viewLifecycleOwner, Observer {
            scheduleListAdapter.updateScheduleList(it)
            if (it.isEmpty()){
                txtScheduleListError?.visibility = View.VISIBLE
                scheduleListProgressLoad?.visibility = View.VISIBLE
            }
            else{
                txtScheduleListError?.visibility = View.GONE
                scheduleListProgressLoad?.visibility = View.GONE
            }
        })
    }
}