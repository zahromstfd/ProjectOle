package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnLogin: Button = findViewById(R.id.buttondaftar)
        val btnRegister: Button = findViewById(R.id.buttonmasuk)
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