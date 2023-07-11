package com.example.projectole.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projectole.R

class KeranjangMinumanFragment : Fragment() {
    private lateinit var minusButton: ImageButton
    private lateinit var plusButton: ImageButton
    private lateinit var quantityTextView: TextView

    private var quantity: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_keranjang_minuman, container, false)

        minusButton = view.findViewById(R.id.minusButtona)
        plusButton = view.findViewById(R.id.plusButtona)
        quantityTextView = view.findViewById(R.id.quantityTextViewa)

//        val backIcon = view.findViewById<ImageButton>(R.id.backicon)
        val basketIcon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileIcon = view.findViewById<ImageButton>(R.id.profileIcon)

//        backIcon.setOnClickListener {
//            val intent = Intent(activity, ListProdukActivity::class.java)
//            startActivity(intent)
//        }

        basketIcon.setOnClickListener {
            val intent = Intent(activity, KeranjangFragment::class.java)
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            val intent = Intent(activity, ProfilFragment::class.java)
            startActivity(intent)
        }

        minusButton.setOnClickListener {
            decrementQuantity()
        }

        plusButton.setOnClickListener {
            incrementQuantity()
        }

        return view
    }

    private fun decrementQuantity() {
        if (quantity > 0) {
            quantity--
            quantityTextView.text = quantity.toString()
        }
    }

    private fun incrementQuantity() {
        quantity++
        quantityTextView.text = quantity.toString()
    }
}
