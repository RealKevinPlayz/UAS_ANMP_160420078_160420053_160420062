package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.R
import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.*

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        //.into(this)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

var DB_NAME = "userdb"
var DB_2 = "articledb"
var DB_DOCTOR = "doctordb"
var DB_SCHEDULE = "scheduledb"
var DB_MEDICINE = "medicinedb"
var DB_PHARMACY = "pharmacydb"
var DB_HOSPITAL = "hospitaldb"
fun buildDB(context: Context):UserDatabase{
    var db = Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME).build()
    return db
}
fun buildArticleDB(context: Context):ArticleDatabase{
    var articleDb = Room.databaseBuilder(context, ArticleDatabase::class.java, DB_2).addMigrations(
        MIGRATION_1_2).build()
    return articleDb
}
fun buildDoctorDB(context: Context): DoctorDatabase {
    var doctorDb = Room.databaseBuilder(context, DoctorDatabase::class.java, DB_DOCTOR).build()
    return doctorDb
}
fun buildScheduleDB(context: Context): ScheduleDatabase {
    var scheduleDb = Room.databaseBuilder(context, ScheduleDatabase::class.java, DB_SCHEDULE).build()
    return scheduleDb
}
fun buildMedicineDB(context: Context): MedicinesDatabase {
    var medicineDb = Room.databaseBuilder(context, MedicinesDatabase::class.java, DB_MEDICINE).build()
    return medicineDb
}
fun buildPharmacyDB(context: Context): PharmaciesDatabase {
    var pharmacyDb = Room.databaseBuilder(context, PharmaciesDatabase::class.java, DB_PHARMACY).build()
    return pharmacyDb
}
fun buildHospitalDB(context: Context): HospitalsDatabase {
    var hospitalDb = Room.databaseBuilder(context, HospitalsDatabase::class.java, DB_HOSPITAL).build()
    return hospitalDb
}
@BindingAdapter("android:imageUrl", "android:hospitalProgressBar")
fun loadPhotoURL(view:ImageView, url:String, pb:ProgressBar){
    view.loadImage(url, pb)
}
/*
fun run() {
    getInstance(context).dataDao().insertAll(DataEntity.populateData())
}
*/

var MIGRATION_1_2 = object : Migration(1, 2){
    override fun migrate(database: SupportSQLiteDatabase) {
        Log.e("migration", "data")
        database.execSQL("insert into article(judul, isi_artikel, url_gambar) values('Regular Exercise: Key for Heart Health', 'Regular exercise is essential for a healthy heart. It strengthens the heart, improves blood circulation, and reduces the risk of cardiovascular diseases. Studies consistently show that individuals who exercise regularly have a lower likelihood of developing heart disease, high blood pressure, and obesity. Incorporating activities like walking, running, swimming, or cycling into daily routines significantly benefits the cardiovascular system. Exercise also contributes to overall well-being by managing stress, improving mood, boosting energy levels, and promoting better sleep. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous exercise per week for optimal heart health.', 'https://blog.1life.co.uk/hubfs/Why%20You%20Should%20Have%20a%20Regular%20Exercise%20Routine.jpg')")
        database.execSQL("insert into article(judul, isi_artikel, url_gambar) values('The Rise of Telehealth in Healthcare', 'Telehealth, the use of technology for remote healthcare, has gained prominence. The COVID-19 pandemic accelerated its adoption, offering access to care during crises and limited physical visits. Telehealth includes video consultations, remote monitoring, and mobile health apps. It improves healthcare accessibility, particularly in rural or underserved areas, reducing wait times and enabling early detection. Telehealth also saves costs by minimizing in-person visits, reducing transportation expenses, and potentially decreasing hospital readmissions. However, it has limitations and not all conditions can be addressed remotely. Patient information privacy and security are crucial in telehealth implementation.', 'https://www.pointstar.co.id/wp-content/uploads/2018/01/Telehealth-services.png')")
        database.execSQL("insert into article(judul, isi_artikel, url_gambar) values('Addressing Healthcare Workforce Shortage in Rural Areas', 'Rural areas face healthcare workforce shortages, limiting access to care. Factors like low population density and limited infrastructure contribute to this challenge. Strategies to address the issue include offering incentives to healthcare professionals, such as loan repayment programs and tax benefits, to attract them to rural areas. Creating residency programs and providing professional development opportunities can also help. Collaborations between rural and urban healthcare facilities, telehealth, and expanding healthcare education programs in rural regions can improve access to quality care. Overcoming workforce shortages is crucial to ensure adequate healthcare services for rural populations.', 'https://www.expatica.com/app/uploads/sites/10/2014/05/english-countryside.jpg')")
    }
}