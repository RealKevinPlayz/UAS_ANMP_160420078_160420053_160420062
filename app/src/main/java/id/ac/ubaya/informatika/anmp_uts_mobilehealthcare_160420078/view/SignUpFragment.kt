package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBack.setOnClickListener {
            val action = SignUpFragmentDirections.signUpToSignIn()
            Navigation.findNavController(it).navigate(action)
        }
        btnRegister.setOnClickListener {
            val action = SignUpFragmentDirections.signUpToSignIn()
            Navigation.findNavController(it).navigate(action)
        }
    }
}