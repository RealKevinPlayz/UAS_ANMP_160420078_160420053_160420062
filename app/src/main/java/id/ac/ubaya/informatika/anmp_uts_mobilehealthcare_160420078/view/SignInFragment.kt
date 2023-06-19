package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*

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
        buttonRegister.setOnClickListener {
            val action = SignInFragmentDirections.signInToSignUp()
            Navigation.findNavController(it).navigate(action)
        }
        buttonSignIn.setOnClickListener {
            var txtUsername = view.findViewById<EditText>(R.id.txtUsername)
            var txtPassword = view.findViewById<EditText>(R.id.txtPassword)
            viewModel.fetch(txtUsername.text.toString(), txtPassword.text.toString())
            Log.e("123", "123")
            var intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}