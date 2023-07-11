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
import com.example.projectole.adapter.MinumanAdapter
import com.example.projectole.databinding.ActivityMainBinding
import com.example.projectole.model.Minuman
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MinumanFragment : Fragment() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MinumanAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minuman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // var tampilproduk = view.findViewById<RecyclerView>(R.id.tampilproduk)
        val btnBeli1 = view.findViewById<Button>(R.id.btnBeli1)
        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val basketicon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)
        val tampilminuman = view.findViewById<RecyclerView>(R.id.rvUser2)

        val adapter = MinumanAdapter(ArrayList())
//        tampilproduk.adapter = adapter
//        tampilproduk.layoutManager = LinearLayoutManager(requireContext())

        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        tampilminuman.layoutManager = layoutManager
        tampilminuman.adapter = adapter

        databaseRef = FirebaseDatabase.getInstance().getReference("minuman")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val minumanList = ArrayList<Minuman>()
                for (snapshot in dataSnapshot.children) {
                    val minuman = snapshot.getValue(Minuman::class.java)
                    minuman?.let { minumanList.add(it) }
                }
                adapter.setData(minumanList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }
}