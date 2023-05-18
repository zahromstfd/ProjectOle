package com.example.projectole

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
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
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radio1 = findViewById(R.id.radio1)
        radio2 = findViewById(R.id.radio2)
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
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = group.findViewById<RadioButton>(checkedId)
            val gender = selectedRadioButton.text.toString()
        }
        // Display a success message or perform any other desired actions
        showToast("Profile sukses tersimpan!")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}