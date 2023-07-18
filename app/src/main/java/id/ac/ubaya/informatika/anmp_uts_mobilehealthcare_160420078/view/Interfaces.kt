package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.view

import android.view.View
import android.widget.CompoundButton

interface ArticleLayoutInterface{

}

interface DoctorLayoutInterface{
    fun onButtonDetailDoctorClick(v: View)
}

interface HospitalLayoutInterface{
    fun onButtonDetailHospitalClick(v: View)
}

interface MedicineLayoutInterface{
    fun onButtonDetailMedicineClick(v: View)
}

interface PharmacyLayoutInterface{
    fun onButtonDetailPharmacyClick(v: View)
}