package com.example.tugassemestersatuapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FolmulirPendaftaranActivity : AppCompatActivity() {
    lateinit var IVBack : ImageView
    lateinit var etNama : EditText
    lateinit var etKelasJurusan : EditText
    lateinit var etAlamat : EditText
    lateinit var etNoHp : EditText
    lateinit var RGJenisKelamin : RadioGroup
    lateinit var RBLaki : RadioButton
    lateinit var RBPerempuan : RadioButton
    lateinit var SpEkstra : Spinner
    lateinit var BKirim : Button
    lateinit var tvEror : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_folmulir_pendaftaran)
        init()

        BKirim.setOnClickListener {
            kirim()
        }
        IVBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        IVBack = findViewById(R.id.IVBack)
        etNama = findViewById(R.id.etNama)
        etKelasJurusan = findViewById(R.id.etKelasJurusan)
        etAlamat = findViewById(R.id.etAlamat)
        etNoHp = findViewById(R.id.etNoHp)
        RGJenisKelamin = findViewById(R.id.RGJenisKelamin)
        RBLaki = findViewById(R.id.RBLaki)
        RBPerempuan = findViewById(R.id.RBPerempuan)
        SpEkstra = findViewById(R.id.SpEkstra)
        BKirim = findViewById(R.id.BKirim)
        tvEror = findViewById(R.id.tvEror)
    }
    fun kirim(){
        if (etNama.text.isEmpty()){
            etNama.setError("Nama Harus Diisi !")
        }else if (etKelasJurusan.text.isEmpty()) {
            etKelasJurusan.setError("Kelas dan Jurusan Harus Diisi !")
        }else if (etAlamat.text.isEmpty()) {
            etAlamat.setError("Alamat Harus Diisi !")
        }else if (etNoHp.text.isEmpty()) {
            etNoHp.setError("NoHp Harus Diisi !")
        }else if (RGJenisKelamin.checkedRadioButtonId ==-1) {
            tvEror.text = "Harus Memilih Salah Satu ! "
            tvEror.visibility= View.VISIBLE
        } else{
            tvEror.text = ""
            tvEror.visibility= View.GONE

            GlobalScope.launch(Dispatchers.Default) {
                delay(1000)
                withContext(Dispatchers.Main) {
                    showDisplay()
                }
            }

        }
    }
    fun showDisplay(){
        val nama = etNama.text.toString()
        val kelas = etKelasJurusan.text.toString()
        val alamat = etAlamat.text.toString()
        val nohp = etNoHp.text.toString()
        val selectedRadioButtonId = RGJenisKelamin.checkedRadioButtonId
        val jenisKelamin = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
        val ekstra = SpEkstra.selectedItem.toString()


        val builder = AlertDialog.Builder(this)
//            builder.setIcon(R.drawable.)
        builder.setTitle("Data Yang Dikirim")
        builder.setMessage("Isi data adalah :\nNama: $nama\nKelas/Jurusan: $kelas\nAlamat: $alamat\nNo Hp: $nohp\nJenis Kelamin: $jenisKelamin\nEkstrakulikuler: $ekstra")
        builder.setPositiveButton("Kembali Ke dasbor") { _, _ ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        builder.show()
    }
}