package com.example.projectole.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projectole.R

class NotifikasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifikasi, container, false)

        val backIcon = view.findViewById<ImageButton>(R.id.backicon)
        val basketIcon = view.findViewById<ImageButton>(R.id.basketIcon)
        val profileIcon = view.findViewById<ImageButton>(R.id.profileIcon)

        backIcon.setOnClickListener {
            activity?.onBackPressed()
        }

        basketIcon.setOnClickListener {
            // TODO: Handle basket icon click
        }

        profileIcon.setOnClickListener {
            // TODO: Handle profile icon click
        }

        val orderReceivedLayout = view.findViewById<LinearLayout>(R.id.layout_order_received)
        val pendingPaymentLayout = view.findViewById<LinearLayout>(R.id.layout_pending_payment)
        val paymentSuccessfulLayout = view.findViewById<LinearLayout>(R.id.layout_payment_successful)

        val orderReceivedIcon = view.findViewById<ImageView>(R.id.icon_order_received)
        val pendingPaymentIcon = view.findViewById<ImageView>(R.id.icon_pending_payment)
        val paymentSuccessfulIcon = view.findViewById<ImageView>(R.id.icon_payment_successful)

        val orderReceivedText = view.findViewById<TextView>(R.id.text_order_received)
        val pendingPaymentText = view.findViewById<TextView>(R.id.text_pending_payment)
        val paymentSuccessfulText = view.findViewById<TextView>(R.id.text_payment_successful)

        val orderReceivedTime = view.findViewById<TextView>(R.id.time_order_received)
        val pendingPaymentTime = view.findViewById<TextView>(R.id.time_pending_payment)
        val paymentSuccessfulTime = view.findViewById<TextView>(R.id.time_payment_successful)

        orderReceivedText.text = "Order Received"
        orderReceivedTime.text = "10:00 AM"

        pendingPaymentText.text = "Pending Payment"
        pendingPaymentTime.text = "11:00 AM"

        paymentSuccessfulText.text = "Payment Successful"
        paymentSuccessfulTime.text = "11:00 AM"

        return view
    }
}
