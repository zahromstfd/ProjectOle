package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
@Suppress("DEPRECATION")
class IntroMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_main)
        Handler().postDelayed({
            val pindah = Intent(this, LoginActivity::class.java)
            startActivity(pindah)
            finish()
        }, 2000)// ketika aplikasi pertama kli dibuka dia menuju splashcreen dan akan delay
        // selama 2000s kmdn lgsg menuju halaman login

        //agar saat program dirun munculnya di splass page, kita hrs menyettingnya di manifest
    }
}