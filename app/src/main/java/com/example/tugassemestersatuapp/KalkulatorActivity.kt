package com.example.tugassemestersatuapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorActivity : AppCompatActivity() {
    lateinit var TVDisplay : TextView
    lateinit var TVClearAll : TextView
    lateinit var TVPlusMinus : TextView
    lateinit var BBAgi : Button
    lateinit var BKali : Button
    lateinit var BKurang : Button
    lateinit var BTambah : Button
    lateinit var BHitung : Button
    lateinit var B9 : Button
    lateinit var B8 : Button
    lateinit var B7 : Button
    lateinit var B6 : Button
    lateinit var B5 : Button
    lateinit var B4 : Button
    lateinit var B3 : Button
    lateinit var B2 : Button
    lateinit var B1 : Button
    lateinit var BNol : Button
    lateinit var BKoma : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        init()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        TVDisplay = findViewById(R.id.TVDisplay)
        TVClearAll = findViewById(R.id.TVClearAll)
        TVPlusMinus = findViewById(R.id.TVPlusMinus)
        BBAgi = findViewById(R.id.BBAgi)
        BKali = findViewById(R.id.BKali)
        BKurang = findViewById(R.id.BKurang)
        BTambah = findViewById(R.id.BTambah)
        BHitung = findViewById(R.id.BHitung)
        B9 = findViewById(R.id.B9)
        B8 = findViewById(R.id.B8)
        B7 = findViewById(R.id.B7)
        B6 = findViewById(R.id.B6)
        B5 = findViewById(R.id.B5)
        B4 = findViewById(R.id.B4)
        B3 = findViewById(R.id.B3)
        B2 = findViewById(R.id.B2)
        B1 = findViewById(R.id.B1)
        BNol = findViewById(R.id.BNol)
        BKoma = findViewById(R.id.BKoma)
    }
    fun tombol(){
        B9.setOnClickListener{
            val angka = 9.0
            TVDisplay.text="9"
        }
        B8.setOnClickListener{
            val angka = 8.0
            TVDisplay.text="9"
        }
        B7.setOnClickListener{
            val angka = 7.0
            TVDisplay.text="7"
        }
        B6.setOnClickListener{
            val angka = 6.0
            TVDisplay.text="6"
        }
        B5.setOnClickListener{
            val angka = 5.0
            TVDisplay.text="5"
        }
        B4.setOnClickListener{
            val angka = 4.0
            TVDisplay.text="4"
        }
        B3.setOnClickListener{
            val angka = 3.0
            TVDisplay.text="3"
        }
        B2.setOnClickListener{
            val angka = 2.0
            TVDisplay.text="2"
        }
        B1.setOnClickListener{
            val angka = 1.0
            TVDisplay.text="1"
        }
        BNol.setOnClickListener{
            val angka = 0.0
            TVDisplay.text="0"
        }
    }
}