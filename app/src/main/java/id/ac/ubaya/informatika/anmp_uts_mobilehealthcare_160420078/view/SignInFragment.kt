package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Observable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentDoctorsDetailBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentSignInBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_in.*
import java.util.concurrent.TimeUnit

class SignInFragment : Fragment(), ButtonSignInLayoutInterface {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentSignInBinding
    var login = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
  //      return inflater.inflate(R.layout.fragment_sign_in, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentSignInBinding>(inflater,
          R.layout.fragment_sign_in, container, false)
      return dataBinding.root
    }
    //tes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.btnListener = this
        var sharedFile = "id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078"
        var shared = this.requireActivity()
            .getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = shared.edit();
        var userID = shared.getInt("userID", 0)

        if(userID != 0){
            var intent = Intent(activity, MainActivity::class.java)
            editor.putInt("userID", userID)
            //Log.wtf("current logged user", userID.toString())
            editor.apply()
            startActivity(intent)
        }
        /*
        buttonRegister.setOnClickListener {
            val action = SignInFragmentDirections.signInToSignUp()
            Navigation.findNavController(it).navigate(action)
        }

         */
        buttonSignIn.setOnClickListener {
            var txtUsername = view.findViewById<EditText>(R.id.txtUsername)
            var txtPassword = view.findViewById<EditText>(R.id.txtPassword)
            login = viewModel.fetch(txtUsername.text.toString(), txtPassword.text.toString())
            Toast.makeText(view.context, "Checking Data", Toast.LENGTH_LONG).show()
            val observableNotification = io.reactivex.rxjava3.core.Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    login = viewModel.fetch(txtUsername.text.toString(), txtPassword.text.toString())
                    //Log.e("login check", login.toString())
                    if(login != 0){
                        var intent = Intent(activity, MainActivity::class.java)
                        editor.putInt("userID", login)
                        editor.apply()
                        Log.wtf("Loggin in user", login.toString())
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(view.context, "Incorrect username or password", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
    fun onBackPressed() {

    }
    /*
    override fun onSignIn(v: View) {

    }
    */
}