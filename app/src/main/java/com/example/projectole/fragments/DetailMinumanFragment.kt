package com.example.projectole.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectole.R

class DetailMinumanFragment : Fragment() {
    private lateinit var minusButton: ImageButton
    private lateinit var plusButton: ImageButton
    private lateinit var quantityTextView: TextView
    private lateinit var addToCartButton: Button

    private var quantity: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_minuman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        minusButton = view.findViewById(R.id.minusButton)
        plusButton = view.findViewById(R.id.plusButton)
        quantityTextView = view.findViewById(R.id.quantityTextView)
        addToCartButton = view.findViewById(R.id.addToCartButton)

//        val backicon = view.findViewById<ImageButton>(R.id.backicon)
        val basketicon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = view.findViewById<ImageButton>(R.id.profileIcon)

//        backicon.setOnClickListener {
//            val intent = Intent(requireContext(), ListProdukActivity::class.java)
//            startActivity(intent)
//        }

        basketicon.setOnClickListener{
            val basket = Intent(requireContext(), KeranjangFragment::class.java)
            startActivity(basket)
        }

        profileicon.setOnClickListener{
            val profile = Intent(requireContext(), ProfilFragment::class.java)
            startActivity(profile)
        }
        minusButton.setOnClickListener {
            decrementQuantity()
        }

        plusButton.setOnClickListener {
            incrementQuantity()
        }

        addToCartButton.setOnClickListener {
            addToCart()
        }
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

    private fun addToCart() {
        val productName = view?.findViewById<TextView>(R.id.productNameTextView)?.text.toString()
        val message = "Added $quantity $productName to cart"
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}