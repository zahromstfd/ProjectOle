package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MasukActivity : AppCompatActivity() {

    private lateinit var editUsername: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btndaftar: Button

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        editUsername = findViewById(R.id.EditUsernameLogin)
        editPassword = findViewById(R.id.EditPasswordLogin)
        btnLogin = findViewById(R.id.btnmasuk)
        btndaftar = findViewById(R.id.btndaf)

        btnLogin.setOnClickListener {
            val username = editUsername.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                processLogin(username, password)
            } else {
                showToast("Silahkan isi username dan password")
            }
        }

        btndaftar.setOnClickListener {
            startActivity(Intent(this, DaftarActivity::class.java))
        }
    }

    private fun processLogin(username: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(username, password)
            .addOnSuccessListener {
                showToast("Login berhasil")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { error ->
                showToast("Login gagal: ${error.localizedMessage}")
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
