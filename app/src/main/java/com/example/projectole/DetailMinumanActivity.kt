package com.example.projectole

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailMinumanActivity : AppCompatActivity() {
    private lateinit var minusButton: ImageButton
    private lateinit var plusButton: ImageButton
    private lateinit var quantityTextView: TextView
    private lateinit var addToCartButton: Button

    private var quantity: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_minuman)

        minusButton = findViewById(R.id.minusButton)
        plusButton = findViewById(R.id.plusButton)
        quantityTextView = findViewById(R.id.quantityTextView)
        addToCartButton = findViewById(R.id.addToCartButton)

        val backicon = findViewById<ImageButton>(R.id.backicon)
        val basketicon = findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener{
            val intent = Intent(this, ListProdukActivity::class.java)
            startActivity(intent)
        }
        basketicon.setOnClickListener{
            val intent = Intent(this, KeranjangMinumanActivity::class.java)
            startActivity(intent)
        }

        profileicon.setOnClickListener{
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
        minusButton.setOnClickListener {
            decrementQuantity()
        }

        plusButton.setOnClickListener {
            incrementQuantity()
        }

        addToCartButton.setOnClickListener {
            val intent = Intent(this, KeranjangMinumanActivity::class.java)
            startActivity(intent)
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
        val productName = findViewById<TextView>(R.id.productNameTextView).text.toString()
        val message = "Added $quantity $productName to cart"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
