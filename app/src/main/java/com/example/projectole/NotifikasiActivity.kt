package com.example.projectole

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotifikasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi)

        val backIcon = findViewById<ImageButton>(R.id.backicon)
        val basketIcon = findViewById<ImageButton>(R.id.basketIcon)
        val profileIcon = findViewById<ImageButton>(R.id.profileIcon)

        backIcon.setOnClickListener {
            onBackPressed()
        }

        basketIcon.setOnClickListener {
            // TODO: Handle basket icon click
        }

        profileIcon.setOnClickListener {
            // TODO: Handle profile icon click
        }

        val orderReceivedLayout = findViewById<LinearLayout>(R.id.layout_order_received)
        val pendingPaymentLayout = findViewById<LinearLayout>(R.id.layout_pending_payment)
        val paymentSuccessfulLayout = findViewById<LinearLayout>(R.id.layout_payment_successful)

        val orderReceivedIcon = findViewById<ImageView>(R.id.icon_order_received)
        val pendingPaymentIcon = findViewById<ImageView>(R.id.icon_pending_payment)
        val paymentSuccessfulIcon = findViewById<ImageView>(R.id.icon_payment_successful)

        val orderReceivedText = findViewById<TextView>(R.id.text_order_received)
        val pendingPaymentText = findViewById<TextView>(R.id.text_pending_payment)
        val paymentSuccessfulText = findViewById<TextView>(R.id.text_payment_successful)

        val orderReceivedTime = findViewById<TextView>(R.id.time_order_received)
        val pendingPaymentTime = findViewById<TextView>(R.id.time_pending_payment)
        val paymentSuccessfulTime = findViewById<TextView>(R.id.time_payment_successful)

        orderReceivedText.text = "Order Received"
        orderReceivedTime.text = "10:00 AM"

        pendingPaymentText.text = "Pending Payment"
        pendingPaymentTime.text = "11:00 AM"

        paymentSuccessfulText.text = "Payment Successful"
        paymentSuccessfulTime.text = "11:00AM"
    }
}