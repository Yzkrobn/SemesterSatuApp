package com.example.tugassemestersatuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var TVMulaiKartuProfil : TextView
    lateinit var TVMulaiFormulir : TextView
    lateinit var TVMulaiKonversiSuhu : TextView
    lateinit var TVMulaiKalkulator : TextView
    lateinit var TVSelamat : TextView
    lateinit var TVWaktu : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        init()
        pewaktu()
        TVMulaiKartuProfil.setOnClickListener{
            val intent = Intent(this, CardViewProvileActivity::class.java)
            startActivity(intent)
        }
        TVMulaiFormulir.setOnClickListener{
            val intent = Intent(this, FolmulirPendaftaranActivity::class.java)
            startActivity(intent)
        }
        TVMulaiKonversiSuhu.setOnClickListener{
            val intent = Intent(this, KonversiSuhuActivity::class.java)
            startActivity(intent)
        }
        TVMulaiKalkulator.setOnClickListener{
            showDisplay()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        TVMulaiKartuProfil = findViewById(R.id.TVMulaiKartuProfil)
        TVMulaiFormulir = findViewById(R.id.TVMulaiFormulir)
        TVMulaiKonversiSuhu = findViewById(R.id.TVMulaiKonversiSuhu)
        TVMulaiKalkulator = findViewById(R.id.TVMulaiKalkulator)
        TVSelamat = findViewById(R.id.TVSelamat)
        TVWaktu = findViewById(R.id.TVWaktu)
    }
    fun showDisplay(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Aplikasi")
        builder.setMessage("PIlih Antara Kalkulator Sederhana Atau Kalkulator")
        builder.setPositiveButton("Kalkulator Sederhana") { _, _ ->
            val intent = Intent(this, KalkulatorSederhanaActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton("Kalkulator"){ _, _ ->
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
    @SuppressLint("SimpleDateFormat")
    private fun pewaktu() {
        val jam = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val hth = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
        val result = when (jam) {
            in 0..11 -> "Selamat Pagi"
            in 12..15 -> "Selamat Siang"
            in 16..18 -> "Selamat Sore"
            else -> "Selamat Malam"
        }
        TVSelamat.text = result
        TVWaktu.text = hth.format(Calendar.getInstance().time)
    }
}