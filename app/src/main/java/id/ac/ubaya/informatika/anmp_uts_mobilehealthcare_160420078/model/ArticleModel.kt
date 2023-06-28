package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @ColumnInfo(name="judul")
    var judul: String,
    @ColumnInfo(name="isi_artikel")
    var isiArtikel: String,
    @ColumnInfo(name="url_gambar")
    var urlGambar: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object{
        fun populateData(): Array<Article>{
            return arrayOf(
                Article("Regular Exercise: Key for Heart Health", "Regular exercise is essential for a healthy heart. It strengthens the heart, improves blood circulation, and reduces the risk of cardiovascular diseases. Studies consistently show that individuals who exercise regularly have a lower likelihood of developing heart disease, high blood pressure, and obesity. Incorporating activities like walking, running, swimming, or cycling into daily routines significantly benefits the cardiovascular system. Exercise also contributes to overall well-being by managing stress, improving mood, boosting energy levels, and promoting better sleep. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous exercise per week for optimal heart health.", "https://blog.1life.co.uk/hubfs/Why%20You%20Should%20Have%20a%20Regular%20Exercise%20Routine.jpg"),
                Article("The Rise of Telehealth in Healthcare", "Telehealth, the use of technology for remote healthcare, has gained prominence. The COVID-19 pandemic accelerated its adoption, offering access to care during crises and limited physical visits. Telehealth includes video consultations, remote monitoring, and mobile health apps. It improves healthcare accessibility, particularly in rural or underserved areas, reducing wait times and enabling early detection. Telehealth also saves costs by minimizing in-person visits, reducing transportation expenses, and potentially decreasing hospital readmissions. However, it has limitations and not all conditions can be addressed remotely. Patient information privacy and security are crucial in telehealth implementation.", "https://www.pointstar.co.id/wp-content/uploads/2018/01/Telehealth-services.png"),
                Article("Addressing Healthcare Workforce Shortage in Rural Areas", "Rural areas face healthcare workforce shortages, limiting access to care. Factors like low population density and limited infrastructure contribute to this challenge. Strategies to address the issue include offering incentives to healthcare professionals, such as loan repayment programs and tax benefits, to attract them to rural areas. Creating residency programs and providing professional development opportunities can also help. Collaborations between rural and urban healthcare facilities, telehealth, and expanding healthcare education programs in rural regions can improve access to quality care. Overcoming workforce shortages is crucial to ensure adequate healthcare services for rural populations.", "https://www.expatica.com/app/uploads/sites/10/2014/05/english-countryside.jpg")
            )
        }
    }
}
/*
@Entity
class DataEntity(var imageUrl: String, var title: String, var text: String) {

    companion object {
        fun populateData(): Array<DataEntity> {
            return arrayOf(
                DataEntity("image1.jpg", "title1", "text1"),
                DataEntity("image2.jpg", "title2", "text2"),
                DataEntity("image3.jpg", "title3", "text3"),
                DataEntity("image4.jpg", "title4", "text4"),
                DataEntity("image5.jpg", "title5", "text5")
            )
        }
    }
}
*/