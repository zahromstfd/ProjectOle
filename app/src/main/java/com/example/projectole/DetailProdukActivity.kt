package com.example.projectole

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailProductActivity : AppCompatActivity() {

    private lateinit var basketIcon: ImageButton
    private lateinit var profileIcon: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        basketIcon = findViewById(R.id.basketIcon)
        profileIcon = findViewById(R.id.profileIcon)

        // Add click listeners to the icons
        basketIcon.setOnClickListener {
            Toast.makeText(this, "Basket icon clicked", Toast.LENGTH_SHORT).show()
        }

        profileIcon.setOnClickListener {
            Toast.makeText(this, "Profile icon clicked", Toast.LENGTH_SHORT).show()
        }

        val minusButton: ImageButton = findViewById(R.id.minusButton)
        val plusButton: ImageButton = findViewById(R.id.plusButton)
        val quantityTextView: TextView = findViewById(R.id.quantityTextView)
        val addToCartButton: Button = findViewById(R.id.addToCartButton)

        minusButton.setOnClickListener {
            val quantity = quantityTextView.text.toString().toInt()
            if (quantity > 0) {
                quantityTextView.text = (quantity - 1).toString()
            }
        }

        plusButton.setOnClickListener {
            val quantity = quantityTextView.text.toString().toInt()
            quantityTextView.text = (quantity + 1).toString()
        }

        addToCartButton.setOnClickListener {
            val quantity = quantityTextView.text.toString().toInt()
            val productName = findViewById<TextView>(R.id.productNameTextView).text.toString()
            val message = "Added $quantity $productName to cart"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}