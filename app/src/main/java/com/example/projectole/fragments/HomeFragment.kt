package com.example.projectole.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.projectole.KeranjangActivity
import com.example.projectole.ListMinuman
import com.example.projectole.ListProdukActivity
import com.example.projectole.MasukActivity
import com.example.projectole.ProfilActivity
import com.example.projectole.R

class HomeFragment : Fragment() {

    private lateinit var btnSearch: Button
    private lateinit var btnMakanan: Button
    private lateinit var btnMinuman: Button
    private lateinit var etKeyword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        btnSearch = view.findViewById(R.id.btnSearch)
        etKeyword = view.findViewById(R.id.etKeyword)
        btnMakanan = view.findViewById(R.id.btnMakanan)
        btnMinuman = view.findViewById(R.id.btnMinuman)

        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val basketicon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener {
            val intent = Intent(requireContext(), MasukActivity::class.java)
            startActivity(intent)
        }

        basketicon.setOnClickListener {
            val intent = Intent(requireContext(), KeranjangFragment::class.java)
            startActivity(intent)
        }

        profileicon.setOnClickListener {
            val intent = Intent(requireContext(), ProfilActivity::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val keyword = etKeyword.text.toString()

            // Memulai activity baru dengan mengirimkan data pencarian
            val intent = Intent(requireContext(), ListProdukActivity::class.java)
            intent.putExtra("keyword", keyword)
            startActivity(intent)
        }

        btnMakanan.setOnClickListener {
            // Memulai activity baru tanpa data pencarian
            val intent = Intent(requireContext(), ListProdukActivity::class.java)
            startActivity(intent)
        }

        btnMinuman.setOnClickListener {
            // Memulai activity baru tanpa data pencarian
            val intent = Intent(requireContext(), ListMinuman::class.java)
            startActivity(intent)
        }

        return view

    }
}
