package com.example.projectole.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import com.example.projectole.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

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
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val uIdRef = FirebaseDatabase.getInstance().getReference("users").child(uid)
        uIdRef.get().addOnCompleteListener{
            if (it.isSuccessful){
                val snapshot  = it.result
                val name = snapshot.child("fullname").getValue<String>()
                Log.d("Nama Lengkap", "$name")
                editTextFullName.setText(name)
            }
        }

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
            val fullname = editTextFullName.text.toString()
            val date = editTextDateOfBirth.text.toString()
            val pass = editTextPassword.text.toString()
            val phone = editTextPhoneNumber.text.toString()
            val email = editTextEmail.text.toString()
            val address = editTextAddress.text.toString()
            // Save the profile information
//            saveProfile()
            val user = User(fullname, date, pass, phone, email, address)
            Log.d("UID", "User ID : $uid")
            if (uid != null) {
                Log.d("UID", "User ID : $uid")

                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful) {

                        Toast.makeText(
                            context,
                            "Berhasil Update",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Gagal update profil",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            } else {
                Log.d("UID", "User ID : $uid")
            }
        }
    }
    private fun uploadProfilePicture() {
        imageUri = Uri.parse("android.resource:///${R.drawable.user}")
        storageReference =
            FirebaseStorage.getInstance().getReference("Users/" + auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(context, "Profil sukses tersimpan", Toast.LENGTH_SHORT)
                .show()

        }.addOnFailureListener {
            Toast.makeText(context, "Gagal Upload gambar", Toast.LENGTH_SHORT).show()
        }
    }
}

//    private fun saveProfile() {
//        val fullName = editTextFullName.text.toString()
//        val dateOfBirth = editTextDateOfBirth.text.toString()
//        val password = editTextPassword.text.toString()
//        val phoneNumber = editTextPhoneNumber.text.toString()
//        val email = editTextEmail.text.toString()
//        val address = editTextAddress.text.toString()
//        val gender = if (radio1.isChecked) radio1.text.toString() else radio2.text.toString()
//
//        // Display a success message or perform any other desired actions
//        showToast("Profile sukses tersimpan!")
//    }

//    private fun showToast(message: String) {
//        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//    }


