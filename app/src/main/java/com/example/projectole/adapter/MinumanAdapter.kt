package com.example.projectole.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectole.databinding.ListProductBinding
import com.example.projectole.model.Minuman
import com.google.firebase.database.FirebaseDatabase

class MinumanAdapter(private val dataProduk: ArrayList<Minuman>) : RecyclerView.Adapter<MinumanAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListProductBinding) : RecyclerView.ViewHolder(binding.root)

    private val databaseRef = FirebaseDatabase.getInstance().getReference("Minuman")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataProduk.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.namaproduk.text = dataProduk[position].minuman
        holder.binding.harga.text = dataProduk[position].harga.toString()
    }

    fun setData(newData: ArrayList<Minuman>) {
        dataProduk.clear()
        dataProduk.addAll(newData)
        notifyDataSetChanged()
    }
}
