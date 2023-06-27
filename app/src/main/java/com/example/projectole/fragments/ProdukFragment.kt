package com.example.projectole.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.projectole.*

class ProdukFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_list_produk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBeli1 = view.findViewById<Button>(R.id.btnBeli1)
        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val basketicon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        basketicon.setOnClickListener {
            val intent = Intent(requireContext(), KeranjangMinumanActivity::class.java)
            startActivity(intent)
        }

        profileicon.setOnClickListener {
            val intent = Intent(requireContext(), ProfilActivity::class.java)
            startActivity(intent)
        }

        btnBeli1.setOnClickListener {
            val intent = Intent(requireContext(), DetailProdukActivity::class.java)
            startActivity(intent)
        }
    }
}
