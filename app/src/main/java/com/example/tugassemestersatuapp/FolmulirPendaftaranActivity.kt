package com.example.tugassemestersatuapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class FolmulirPendaftaranActivity : AppCompatActivity() {
    lateinit var IVBack : ImageView
    lateinit var etNama : EditText
    lateinit var etAlamat : EditText
    lateinit var etNoHp : EditText
    lateinit var CGJenisKelamin : ChipGroup
    lateinit var ChLaki : Chip
    lateinit var ChPerempuan : Chip
    lateinit var SpEkstra : Spinner
    lateinit var BKirim : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_folmulir_pendaftaran)
        init()
        BKirim.setOnClickListener{
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
        etAlamat = findViewById(R.id.etAlamat)
        etNoHp = findViewById(R.id.etNoHp)
        CGJenisKelamin = findViewById(R.id.CGJenisKelamin)
        ChLaki = findViewById(R.id.ChLaki)
        ChPerempuan = findViewById(R.id.ChPerempuan)
        SpEkstra = findViewById(R.id.SpEkstra)
        BKirim = findViewById(R.id.BKirim)
    }
    fun kirim(){
        if (etNama.text.isEmpty()){
            etNama.setError("Nama Harus Diisi !")
        }else if (etAlamat.text.isEmpty()) {
            etAlamat.setError("Alamat Harus Diisi !")
        }else if (etNoHp.text.isEmpty()){
            etNoHp.setError("NoHp Harus Diisi !")
        }else if (ChLaki.isChecked){
            etNoHp.setError("NoHp Harus Diisi !")
        }
    }
}