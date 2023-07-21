package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
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
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentSignInBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.databinding.FragmentSignUpBinding
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.User
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment() : Fragment(), ButtonSignUpLayoutInterface {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_up, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
            R.layout.fragment_sign_up, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.btnbacklistener = this
        btnRegister.setOnClickListener {
            var textUsername = view.findViewById<EditText>(R.id.textUsername)
            var textFirstName = view.findViewById<EditText>(R.id.textFirstName)
            var textLastName = view.findViewById<EditText>(R.id.textLastName)
            var textPassword = view.findViewById<EditText>(R.id.textPassword)
            var user = User(textUsername.text.toString(), textFirstName.text.toString(), textLastName.text.toString(), textPassword.text.toString())
            viewModel.addUser(user)
            Toast.makeText(view.context, "User Data added", Toast.LENGTH_LONG).show()
            val action = SignUpFragmentDirections.signUpToSignIn()
            Navigation.findNavController(it).navigate(action)
        }
    }
}