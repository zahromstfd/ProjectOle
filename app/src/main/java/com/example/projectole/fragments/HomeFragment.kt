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
import androidx.navigation.fragment.findNavController
import com.example.projectole.LoginActivity
import com.example.projectole.MasukActivity
import com.example.projectole.R
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private lateinit var btnSearch: Button
    private lateinit var btnMakanan: Button
    private lateinit var btnMinuman: Button
    private lateinit var etKeyword: EditText

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSearch = view.findViewById(R.id.btnSearch)
        etKeyword = view.findViewById(R.id.etKeyword)
        btnMakanan = view.findViewById(R.id.btnMakanan)
        btnMinuman = view.findViewById(R.id.btnMinuman)

        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val logout = view.findViewById<ImageButton>(R.id.logout)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener {
            val intent = Intent(requireContext(), MasukActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }

        profileicon.setOnClickListener {
            val intent = Intent(requireContext(), ProfilFragment::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val keyword = etKeyword.text.toString()

            // Memulai activity baru dengan mengirimkan data pencarian
            val intent = Intent(requireContext(), ProdukFragment::class.java)
            intent.putExtra("keyword", keyword)
            startActivity(intent)
        }

        btnMakanan.setOnClickListener {
            // Memulai activity baru tanpa data pencarian
            findNavController().navigate(R.id.action_homeFragment_to_produkFragment)
        }

        btnMinuman.setOnClickListener {
            // Memulai activity baru tanpa data pencarian
            findNavController().navigate(R.id.action_homeFragment_to_minumanFragment)
        }
    }
}
