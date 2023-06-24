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
    var urlGambar: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}