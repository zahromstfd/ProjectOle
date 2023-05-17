package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView


class ListProdukActivity : AppCompatActivity() {
        private lateinit var btn2: CardView
        private lateinit var btn3: CardView
        private lateinit var btn4: CardView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_produk)
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

       val  btnBeli1 = findViewById<Button>(R.id.btnBeli1)
        val backicon = findViewById<ImageButton>(R.id.backicon)
        val basketicon = findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnBeli1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DetailProdukActivity::class.java)
            startActivity(intent)
        })

    }
}