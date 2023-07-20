package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.ContextUtils.getActivity
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
    override fun onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_SHORT).show()
    }
}