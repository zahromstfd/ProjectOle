package com.example.projectole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnSearch: Button
    private lateinit var btnMakanan: Button
    private lateinit var btnMinuman: Button
    private lateinit var etKeyword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch = findViewById(R.id.btnSearch)
        etKeyword = findViewById(R.id.etKeyword)
        btnMakanan = findViewById(R.id.btnMakanan)
        btnMinuman = findViewById(R.id.btnMinuman)

        val backicon = findViewById<ImageButton>(R.id.backicon)
        val basketicon = findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener{
            val intent = Intent(this, MasukActivity::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val keyword = etKeyword.text.toString()

            // Memulai activity baru dengan mengirimkan data pencarian
            val intent = Intent(this, ListProdukActivity::class.java)
            intent.putExtra("keyword", keyword)
            startActivity(intent)
            }
            btnMakanan.setOnClickListener {

                // Memulai activity baru dengan mengirimkan data pencarian
                val intent = Intent(this, ListProdukActivity::class.java)
                startActivity(intent)
            }
            btnMinuman.setOnClickListener {

                    // Memulai activity baru dengan mengirimkan data pencarian
                val intent = Intent(this, ListMinuman::class.java)
                startActivity(intent)
                }

    }
}


