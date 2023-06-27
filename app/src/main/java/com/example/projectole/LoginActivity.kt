package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectole.DB.DBHelper

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val btnLogin: Button = findViewById(R.id.buttondaftar)
        val btnRegister: Button = findViewById(R.id.buttonmasuk)
        val userDBHelper = DBHelper(this)
        btnLogin.setOnClickListener {

            val intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, MasukActivity::class.java)
            startActivity(intent)

        }

    }
}