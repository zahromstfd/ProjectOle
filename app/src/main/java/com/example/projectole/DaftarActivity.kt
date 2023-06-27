package com.example.projectole

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectole.DB.DBHelper

class DaftarActivity : AppCompatActivity() {
    lateinit var eemail: EditText
    lateinit var epassword: EditText
    lateinit var efullname: EditText
    lateinit var btnregister: Button
    lateinit var userDBHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        eemail = findViewById(R.id.EditEmailRegister)
        epassword = findViewById(R.id.EditPasswordRegister)
        efullname = findViewById(R.id.EditFullnameRegister)
        btnregister = findViewById(R.id.btnmasuk)
        userDBHelper = DBHelper(this)
    }

    fun registerme(view: View) {
        var iemail = eemail.text.toString()
        var ipassword = epassword.text.toString()
        var ifullname = efullname.text.toString()

        var cekuser = userDBHelper.cekUser(iemail)
        var status = "Gagal"
        if (cekuser == "0") {
            userDBHelper.RegisterUser(iemail, ipassword, ifullname)
            status = "Sukses"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        val toast: Toast = Toast.makeText(
            applicationContext,
            status, Toast.LENGTH_SHORT
        )
        toast.show()
    }
}