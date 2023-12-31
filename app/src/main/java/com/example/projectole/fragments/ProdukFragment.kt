package com.example.projectole.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectole.*
import com.example.projectole.adapter.HomeAdapter
import com.example.projectole.databinding.ActivityMainBinding
import com.example.projectole.model.Keranjang
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProdukFragment : Fragment() {
    lateinit var binding : ActivityMainBinding
    lateinit var adapter : HomeAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // var tampilproduk = view.findViewById<RecyclerView>(R.id.tampilproduk)
        val btnBeli1 = view.findViewById<Button>(R.id.btnBeli1)
        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val basketicon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)
        val tampilproduk = view.findViewById<RecyclerView>(R.id.rvUser)

        val adapter = HomeAdapter(ArrayList())
//        tampilproduk.adapter = adapter
//        tampilproduk.layoutManager = LinearLayoutManager(requireContext())

        val layoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
        tampilproduk.layoutManager = layoutManager
        tampilproduk.adapter = adapter

        databaseRef = FirebaseDatabase.getInstance().getReference("keranjang")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val keranjangList = ArrayList<Keranjang>()
                for (snapshot in dataSnapshot.children) {
                    val keranjang = snapshot.getValue(Keranjang::class.java)
                    keranjang?.let { keranjangList.add(it) }
                }
                adapter.setData(keranjangList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
//
//
//        backicon.setOnClickListener {
//            val intent = Intent(requireContext(), MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        basketicon.setOnClickListener {
//            val intent = Intent(requireContext(), KeranjangFragment::class.java)
//            startActivity(intent)
//        }
//
//        profileicon.setOnClickListener {
//            val intent = Intent(requireContext(), ProfilActivity::class.java)
//            startActivity(intent)
//        }
//
//        btnBeli1.setOnClickListener {
//            val intent = Intent(requireContext(), DetailProdukActivity::class.java)
//            startActivity(intent)
//        }
//
//
//
//
    }
}
