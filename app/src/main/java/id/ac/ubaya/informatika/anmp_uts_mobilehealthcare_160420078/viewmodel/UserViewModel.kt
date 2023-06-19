package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.User
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private var job = Job()
    var userLD = MutableLiveData<User>()
    fun addUser(user: User){
        launch {
            //var db = Room.databaseBuilder(getApplication(), TodoDatabase::class.java, "newtododb").build()
            var db = buildDB(getApplication())
            db.userDao().insertAll(user)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    var check = false
    fun fetch(username: String, password: String): Boolean{

        launch {
            var db = buildDB(getApplication())
            var data = db.userDao().selectUser(username, password)
            //userLD.value = data
           // Log.e("userld", data.toString())
            if(data != null){
                check = true
                Log.e("userchecktrue", check.toString())
            }
            Log.e("usercheckfalse", check.toString())
        }
        return check
    }

    fun update(username: String, firstName: String, lastName: String, password: String, id: Int){
        launch {
            var db = buildDB(getApplication())
            db.userDao().update(username, firstName, lastName, password, id)
        }
    }
}