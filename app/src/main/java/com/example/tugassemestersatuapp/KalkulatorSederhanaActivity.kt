package com.example.tugassemestersatuapp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorSederhanaActivity : AppCompatActivity() {
    lateinit var IVBack : ImageView
    lateinit var angka1 : EditText
    lateinit var angka2 : EditText
    lateinit var operasi : Spinner
    lateinit var hitung : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator_sederhana)
        init()
        hitung.setOnClickListener{
            hitung()
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
        angka1 = findViewById(R.id.EtBil1)
        angka2 = findViewById(R.id.EtBil2)
        operasi = findViewById(R.id.SOprasiAritmatika)
        hitung = findViewById(R.id.BtHitung)
    }
    fun hitung() {
        if (angka1.text.isEmpty()) {
            angka1.setError("Isi terlebih dahulu !")
        } else if ( angka2.text.isEmpty()){
            angka2.setError("Isi terlebih dahulu !")
        } else{
            var bil1 = angka1.text.toString().toDouble()
            var bil2 = angka2.text.toString().toDouble()
            var op = operasi.selectedItemPosition

            var hasil = when(op){
                0 -> bil1+bil2
                1 -> bil1-bil2
                2 -> bil1*bil2
                3 -> if (bil2==0.0){
                    Toast.makeText(this,"Tidak bisa membagi dengan 0/Nol",Toast.LENGTH_SHORT).show()
                    return
                }else{
                    bil1/bil2
                }
                else->0.0
            }
            val format = DecimalFormat("#,###,###.##")
            val output = format.format(hasil)
            Toast.makeText(this,"Hasil = $output",Toast.LENGTH_SHORT).show()
        }
    }
}