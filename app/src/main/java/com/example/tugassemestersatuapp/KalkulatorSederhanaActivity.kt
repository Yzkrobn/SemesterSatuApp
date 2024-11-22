package com.example.tugassemestersatuapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorSederhanaActivity : AppCompatActivity() {
    lateinit var angka1:EditText
    lateinit var angka2:EditText
    lateinit var operasi: Spinner
    lateinit var hitung: Button

    var bil1 : Double = 0.0
    var bil2 : Double = 0.0
    var hasil : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator_sederhana)
        init()
        hitung.setOnClickListener(){
            hitung()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        angka1 = findViewById(R.id.EtBil1)
        angka2 = findViewById(R.id.EtBil2)
        operasi = findViewById(R.id.SOprasiAritmatika)
        hitung = findViewById(R.id.BtHitung)
    }
    fun hitung(){
        bil1 = angka1.text.toString().toDoubleOrNull() ?: 0.0
        bil2 = angka2.text.toString().toDoubleOrNull() ?: 0.0

        if (bil2==0){

        }
        hasil = when(operasi.selectedItem){
            0->bil1+bil2
            1->bil1+bil2
            2->bil1+bil2
            3->bil1+bil2
        }


    }
}