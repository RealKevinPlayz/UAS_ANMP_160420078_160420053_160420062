package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentMedicinesDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentProfileBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.User
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.MedicineDetailViewModel
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_medicines_detail.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.concurrent.TimeUnit

class ProfileFragment : Fragment(), ButtonDetailLayoutInterface{
        private lateinit var viewModel: UserViewModel
        private lateinit var dataBinding: FragmentProfileBinding
        var userId = 0

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            //return inflater.inflate(R.layout.fragment_doctors_detail, container, false)
            dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater,
                R.layout.fragment_profile, container, false)
            return dataBinding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
            var shared = this.requireActivity()
                .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

            userId = shared.getInt("userID", 0)

            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            dataBinding.btnListener = this
            viewModel.fetchLoggedUser(userId.toInt())
            observeViewModel()

            btnSaveProfile.setOnClickListener{
                var username = view.findViewById<EditText>(R.id.txtUsernameProfile)
                var firstname = view.findViewById<EditText>(R.id.txtFirstProfile)
                var lastname = view.findViewById<EditText>(R.id.txtLastProfile)
                var password = view.findViewById<EditText>(R.id.txtPasswordProfile)
                viewModel.update(username.text.toString(),firstname.text.toString(),lastname.text.toString(), password.text.toString(),userId)
                Toast.makeText(view.context, "Saving Data", Toast.LENGTH_LONG).show()
                val observableNotification = io.reactivex.rxjava3.core.Observable.timer(3, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Toast.makeText(view.context, "Data Saved", Toast.LENGTH_LONG).show()
                    }
                Navigation.findNavController(it).popBackStack()
            }
        }



        private fun observeViewModel() {
            viewModel.userLD.observe(viewLifecycleOwner, Observer {
                dataBinding.user = it
            })
        }
    }