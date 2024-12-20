package com.example.tugassemestersatuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorActivity : AppCompatActivity() {
    lateinit var IVBack : ImageView
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
    var NilaiAwal: Double = 0.0
    var aksi: String = ""
    var koma: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        init()
        tombol()
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
    @SuppressLint("SetTextI18n")
    fun tombol(){
        TVClearAll.setOnClickListener{
            koma = false
            aksi= ""
            TVDisplay.setText("")
        }
        TVPlusMinus.setOnClickListener{
            if (TVDisplay.text.isNotEmpty()){
                TVDisplay.setText(
                    "${-1 * TVDisplay.text.toString().toDouble()}"
                )
            }
        }
        B1.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.1")
            }else{
                TVDisplay.setText(("${TVDisplay.text}1"))
            }
        }
        B2.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.2")
            }else{
                TVDisplay.setText(("${TVDisplay.text}2"))
            }
        }
        B3.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.3")
            }else{
                TVDisplay.setText(("${TVDisplay.text}3"))
            }
        }
        B4.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.4")
            }else{
                TVDisplay.setText(("${TVDisplay.text}4"))
            }
        }
        B5.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.5")
            }else{
                TVDisplay.setText(("${TVDisplay.text}5"))
            }
        }
        B6.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.6")
            }else{
                TVDisplay.setText(("${TVDisplay.text}6"))
            }
        }
        B7.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.7")
            }else{
                TVDisplay.setText(("${TVDisplay.text}7"))
            }
        }
        B8.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.8")
            }else{
                TVDisplay.setText(("${TVDisplay.text}8"))
            }
        }
        B9.setOnClickListener{
            if (koma){
                TVDisplay.setText("0.9")
            }else{
                TVDisplay.setText(("${TVDisplay.text}9"))
            }
        }
        BNol.setOnClickListener{
            if (TVDisplay.text.isNotEmpty()){
                TVDisplay.setText(("${TVDisplay.text}0"))
            }else{
                koma = true
            }
        }
        BKoma.setOnClickListener{
            if(TVDisplay.text.isNotEmpty()){
                TVDisplay.setText("${TVDisplay.text}.")
            }else{
                koma = true
            }
        }
        BBAgi.setOnClickListener{
            isiData()
            aksi = "bagi"
        }
        BKali.setOnClickListener{
            isiData()
            aksi = "kali"
        }
        BKurang.setOnClickListener{
            isiData()
            aksi = "kurang"
        }
        BTambah.setOnClickListener{
            isiData()
            aksi = "tambah"
        }
        BHitung.setOnClickListener{
            if (aksi.isNotEmpty()){
                val decimalFormat = DecimalFormat("#.###")
                val NilaiDisplay = if (TVDisplay.text.isNotEmpty()){
                    try {
                        TVDisplay.text.toString().toDouble()
                    }catch (e: NumberFormatException){ 0.0 }
                } else {0.0}
                if (aksi.equals("tambah")){
                    val hasilHitung = NilaiAwal + NilaiDisplay
                    val terformat = decimalFormat.format(hasilHitung)
                    TVDisplay.setText(terformat)
                }else if (aksi.equals("kurang")){
                    val hasilHitung = NilaiAwal - NilaiDisplay
                    val terformat  = decimalFormat.format(hasilHitung)
                    TVDisplay.setText(terformat)
                }else if (aksi.equals("kali")) {
                    val hasilHitung = NilaiAwal * NilaiDisplay
                    val terformat = decimalFormat.format(hasilHitung)
                    TVDisplay.setText(terformat)
                }else if (aksi.equals("bagi")){
                    if (TVDisplay.text.toString().toDouble()==0.0){
                        TVDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                        TVDisplay.setText("Tidak bisa membagi dengan 0/Nol")
                    }else{
                        TVDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)
                        val hasilHitung = NilaiAwal / NilaiDisplay
                        val terformat  = decimalFormat.format(hasilHitung)
                        TVDisplay.setText(terformat)
                    }
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    fun isiData(){
        if (TVDisplay.text.isNotEmpty()){
            try {
                NilaiAwal = TVDisplay.text.toString().toDouble()
                TVDisplay.setText("")
            }catch (e: NumberFormatException){
                NilaiAwal = 0.0
            }
        }else{
            NilaiAwal = 0.0
        }
    }
}