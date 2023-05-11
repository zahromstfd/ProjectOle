package com.example.projectole

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    private lateinit var checkBoxMale: CheckBox
    private lateinit var checkBoxFemale: CheckBox
    private lateinit var editTextFullName: EditText
    private lateinit var editTextDateOfBirth: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        // Initialize views
        checkBoxMale = findViewById(R.id.checkBoxMale)
        checkBoxFemale = findViewById(R.id.checkBoxFemale)
        editTextFullName = findViewById(R.id.editTextFullName)
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            // Save the profile information
            saveProfile()
        }
    }

    private fun saveProfile() {
        val fullName = editTextFullName.text.toString()
        val dateOfBirth = editTextDateOfBirth.text.toString()
        val password = editTextPassword.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()
        val email = editTextEmail.text.toString()
        val address = editTextAddress.text.toString()
        val gender = when {
            checkBoxMale.isChecked -> "Laki-laki"
            checkBoxFemale.isChecked -> "Perempuan"
            else -> ""
        }

        // TODO: Save the profile information to the database or perform any other necessary actions

        // Display a success message or perform any other desired actions
        showToast("Profile saved successfully!")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}