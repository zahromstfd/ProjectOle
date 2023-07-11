package com.example.projectole.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectole.R
import com.example.projectole.databinding.ListProductBinding
import com.example.projectole.model.Keranjang
import com.example.projectole.model.Minuman
import com.google.firebase.database.FirebaseDatabase

class HomeAdapter(private val dataProduk: ArrayList<Keranjang>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListProductBinding) : RecyclerView.ViewHolder(binding.root)

    private val databaseRef = FirebaseDatabase.getInstance().getReference("Keranjang")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataProduk.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentProduk = dataProduk[position]

        holder.binding.namaproduk.text = currentProduk.namaproduk
        holder.binding.harga.text = currentProduk.harga.toString()

    }

    fun setData(newData: ArrayList<Keranjang>) {
        dataProduk.clear()
        dataProduk.addAll(newData)
        notifyDataSetChanged()
    }
}