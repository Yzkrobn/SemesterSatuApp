package com.example.tugassemestersatuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Locale

class CardViewProvileActivity : AppCompatActivity() {
    lateinit var IVBack : ImageView
    private lateinit var TVSelamat: TextView
    private lateinit var TVWaktu: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_view_provile)
        init()
        pewaktu()
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
    private fun init(){
        IVBack = findViewById(R.id.IVBack)
        TVSelamat = findViewById(R.id.TVSelamat)
        TVWaktu = findViewById(R.id.TVWaktu)
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