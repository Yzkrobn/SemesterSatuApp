package com.example.tugassemestersatuapp

import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class KonversiSuhuActivity : AppCompatActivity() {
    lateinit var suhuAwal : Spinner
    lateinit var  suhuAkhir : Spinner
    lateinit var  input : EditText
    lateinit var  output : TextView
    lateinit var konversi : Button
    lateinit var bersih : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)
        init()
        bersih.setOnClickListener{
            input.text.clear()
            output.text=""
        }
        konversi.setOnClickListener{
            konversi()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        suhuAwal = findViewById(R.id.spSuhuAwal)
        suhuAkhir = findViewById(R.id.spSuhuAkhir)
        input = findViewById(R.id.etSuhuAwal)
        output = findViewById(R.id.tvHasilSuhuAkhir)
        konversi = findViewById(R.id.btKonversi)
        bersih = findViewById(R.id.btBersihkan)
    }
    fun konversi() {
        if (input.text.isEmpty()) {
            Toast.makeText(this, "Isi nominal suhu !", Toast.LENGTH_SHORT).show()
        } else {
            val sAwal = suhuAwal.selectedItem.toString()
            val sAkhir = suhuAkhir.selectedItem.toString()
            val inp = input.text.toString().toDouble()
            var out = output.text.toString().toDoubleOrNull()

            if (sAwal == "Celcius") {
                if (sAkhir == "Celcius") {
                    out = inp
                } else if (sAkhir == "Fahrenheit") {
                    out = (inp * 9 / 5) + 32
                } else if (sAkhir == "Kelvin") {
                    out = inp + 273.15
                } else if (sAkhir == "Reamur") {
                    out = inp * 4 / 5
                }
            } else if (sAwal == "Fahrenheit") {
                if (sAkhir == "Celcius") {
                    out = (inp - 32) * 5 / 9
                } else if (sAkhir == "Fahrenheit") {
                    out = inp
                } else if (sAkhir == "Kelvin") {
                    out = (inp - 32) * 5 / 9 + 273.15
                } else if (sAkhir == "Reamur") {
                    out = (inp - 32) * 4 / 9
                }
            } else if (sAwal == "Kelvin") {
                if (sAkhir == "Celcius") {
                    out = inp - 273.15
                } else if (sAkhir == "Fahrenheit") {
                    out = (inp - 273.15) * 9 / 5 + 32
                } else if (sAkhir == "Kelvin") {
                    out = inp
                } else if (sAkhir == "Reamur") {
                    out = (inp - 273.15) * 4 / 5
                }
            } else if (sAwal == "Reamur") {
                if (sAkhir == "Celcius") {
                    out = inp * 5 / 4
                } else if (sAkhir == "Fahrenheit") {
                    out = (inp * 9 / 4) + 32
                } else if (sAkhir == "Kelvin") {
                    out = (inp * 5 / 4) + 273.15
                } else if (sAkhir == "Reamur") {
                    out = inp
                }
            }
            val format = DecimalFormat("#,###.##")
            output.text = format.format(out)
        }
    }
}