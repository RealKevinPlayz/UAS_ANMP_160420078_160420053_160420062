package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Intent
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import java.util.concurrent.TimeUnit

class SignInFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }
    //tes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        buttonRegister.setOnClickListener {
            val action = SignInFragmentDirections.signInToSignUp()
            Navigation.findNavController(it).navigate(action)
        }
        buttonSignIn.setOnClickListener {
            var txtUsername = view.findViewById<EditText>(R.id.txtUsername)
            var txtPassword = view.findViewById<EditText>(R.id.txtPassword)
            var login = viewModel.fetch(txtUsername.text.toString(), txtPassword.text.toString())
            Toast.makeText(view.context, "Checking Data", Toast.LENGTH_LONG).show()
            Log.e("login check", login.toString())
            if(login){
                var intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(view.context, "Incorrect username or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}