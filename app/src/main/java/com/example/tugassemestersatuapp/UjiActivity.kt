package com.example.tugassemestersatuapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorActivity2 : AppCompatActivity() {
    //langkah satu
    //deklarasi variabel
    //baik komponen maupun tipe data
    //variabel global
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

    //on create adalah sebuah fungsi pasti ada, karena dia adalah fungsi pertama yang di panggil ketika sebuah activty dijalankan.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        //langkah 3
        //panggil fungsi init
        init()
        pencet()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //langkah 2
    //buat fungsi init
    //digunakan untuk menghasilkan lateinit
    fun init() {
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

    //langkah 4
    //buat fungi pencet
    //event on click listener
    fun pencet() {
        tbclear.setOnClickListener {
            koma = false
            aksi = ""
            tvlayar.setText("")
        }
        tbpm.setOnClickListener {
            if (tvlayar.text.isNotEmpty()) {
                tvlayar.setText(
                    "${-1 * tvlayar.text.toString().toDouble()}"
                )
            }
        }
        tb1.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}1")
            }
        }
        tb2.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}2")
            }
        }
        tb3.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}3")
            }
        }
        tb4.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}4")
            }
        }
        tb5.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}5")
            }
        }
        tb6.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}6")
            }
        }
        tb7.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}7")
            }
        }
        tb8.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}8")
            }
        }
        tb9.setOnClickListener {
            if (koma) {
                tvlayar.setText("0.1")
            } else {
                tvlayar.setText("${tvlayar.text}9")
            }
        }
        tb0.setOnClickListener {
            if (tvlayar.text.isNotEmpty()) {
                tvlayar.setText("${tvlayar.text}0")
            }
        }
        tbkoma.setOnClickListener {
            if (tvlayar.text.isNotEmpty()) {
                tvlayar.setText("${tvlayar.text}.")
            }else{koma = true}
        }
        tbtambah.setOnClickListener {
            isiData()
            aksi = "tambah"
        }
        tbkurang.setOnClickListener {
            isiData()
            aksi = "kurang"
        }
        tbkali.setOnClickListener {
            isiData()
            aksi = "kali"
        }
        tbbagi.setOnClickListener {
            isiData()
            aksi = "bagi"
        }
        tbpersen.setOnClickListener {
            isiData()
            aksi = "persen"
        }
        tbkurung.setOnClickListener {
            val layarText = tvlayar.text.toString()
            if (layarText.count { it == '(' } > layarText.count { it == ')' }) {
                tvlayar.setText("$layarText)")
            } else {
                tvlayar.setText("$layarText(")
            }
        }

        tbsamadengan.setOnClickListener {
            if (aksi.isNotEmpty()) {
                val decimalFormat = DecimalFormat("#.###")
                if (aksi.equals("tambah")) {

                    if (tvlayar.text.isNotEmpty()) {
                        val hasilPerhitungan = NilaiAwal + tvlayar.text.toString().toDouble()
                        val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                        tvlayar.setText(hasilTerformat)
                    }
                } else if (aksi.equals("kurang")) {
                    val hasilPerhitungan = NilaiAwal - tvlayar.text.toString().toDouble()
                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    tvlayar.setText(hasilTerformat)
                } else if (aksi.equals("kali")) {
                    val hasilPerhitungan = NilaiAwal * tvlayar.text.toString().toDouble()
                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    tvlayar.setText(hasilTerformat)
                } else if (aksi.equals("bagi")) {
                    val hasilPerhitungan = NilaiAwal / tvlayar.text.toString().toDouble()
                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    tvlayar.setText(hasilTerformat)
                } else if (aksi.equals("persen")) {
                    val hasilPerhitungan = NilaiAwal * tvlayar.text.toString().toDouble() / 100
                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    tvlayar.setText(hasilTerformat)
                }
            }

        }
    }
    fun isiData() {
        if (tvlayar.text.isNotEmpty()) {
            NilaiAwal = tvlayar.text.toString().toDouble()
            tvlayar.setText("")
        } else {
            NilaiAwal = 0.0
        }
    }
}