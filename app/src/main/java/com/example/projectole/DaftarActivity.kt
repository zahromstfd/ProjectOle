package com.example.projectole
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectole.MainActivity
import com.example.projectole.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class DaftarActivity : AppCompatActivity() {
    private lateinit var eemail: EditText
    private lateinit var epassword: EditText
    private lateinit var efullname: EditText
    private lateinit var btnregister: Button
    private lateinit var epasswordconf: EditText
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
        setContentView(R.layout.activity_daftar)

        eemail = findViewById(R.id.EditEmailRegister)
        epassword = findViewById(R.id.EditPasswordRegister)
        epasswordconf = findViewById(R.id.EditPasswordConfRegister)
        efullname = findViewById(R.id.EditFullnameRegister)
        btnregister = findViewById(R.id.btnmasuk)

        btnregister.setOnClickListener {
            val fullname = efullname.text.toString().trim()
            val email = eemail.text.toString().trim()
            val password = epassword.text.toString().trim()
            val confirmPassword = epasswordconf.text.toString().trim()

            if (fullname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                if (password == confirmPassword) {
                    registerUser(fullname, email, password)
                } else {
                    showToast("Konfirmasi kata sandi harus sama")
                }
            } else {
                showToast("Silahkan isi semua data")
            }
        }
    }

    private fun registerUser(fullname: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = fullname
                    }
                    user?.updateProfile(userUpdateProfile)
                        ?.addOnCompleteListener { updateTask ->
                            if (updateTask.isSuccessful) {
                                showToast("Pendaftaran berhasil")
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    showToast("Pendaftaran gagal: ${task.exception?.message}")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
