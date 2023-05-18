package com.example.projectole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class KeranjangMinumanActivity : AppCompatActivity() {
    private lateinit var minusButton: ImageButton
    private lateinit var plusButton: ImageButton
    private lateinit var quantityTextView: TextView

    private var quantity: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang_minuman)

        minusButton = findViewById(R.id.minusButton)
        plusButton = findViewById(R.id.plusButton)
        quantityTextView = findViewById(R.id.quantityTextView)

        val backicon = findViewById<ImageButton>(R.id.backicon)
        val basketicon = findViewById<ImageButton>(R.id.basketIcon)
        val profileicon = findViewById<ImageButton>(R.id.profileIcon)

        backicon.setOnClickListener {
            val intent = Intent(this, ListProdukActivity::class.java)
            startActivity(intent)
        }
        basketicon.setOnClickListener {
            val intent = Intent(this, KeranjangMinumanActivity::class.java)
            startActivity(intent)
        }

        profileicon.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
        minusButton.setOnClickListener {
            decrementQuantity()
        }

        plusButton.setOnClickListener {
            incrementQuantity()
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

}
