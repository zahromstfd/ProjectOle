package com.example.projectole.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectole.R

class ProfilFragment : Fragment() {
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var editTextFullName: EditText
    private lateinit var editTextDateOfBirth: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        radio1 = view.findViewById(R.id.radio1)
        radio2 = view.findViewById(R.id.radio2)
        editTextFullName = view.findViewById(R.id.editTextFullName)
        editTextDateOfBirth = view.findViewById(R.id.editTextDateOfBirth)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextAddress = view.findViewById(R.id.editTextAddress)
        buttonSave = view.findViewById(R.id.buttonSave)

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
        val gender = if (radio1.isChecked) radio1.text.toString() else radio2.text.toString()

        // Display a success message or perform any other desired actions
        showToast("Profile sukses tersimpan!")
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
