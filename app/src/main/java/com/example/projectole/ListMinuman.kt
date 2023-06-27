package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton



class ListMinuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_minuman)

        val btnBeli1 = findViewById<Button>(R.id.btnBeli1)
        val backicon = findViewById<ImageButton>(R.id.backicon)
        val basketicon = findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        basketicon.setOnClickListener {
            val intent = Intent(this, KeranjangMinumanActivity::class.java)
            startActivity(intent)
        }

        profileicon.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
        btnBeli1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DetailMinumanActivity::class.java)
            startActivity(intent)
        })

    }
}