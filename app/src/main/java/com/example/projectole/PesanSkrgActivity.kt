package com.example.projectole

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PesanSkrgActivity : BottomSheetDialogFragment() {

    private lateinit var titleTextView: TextView
    private lateinit var itemsRadioGroup: RadioGroup
    private lateinit var placeOrderButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_pesan_skrg, container, false)

        // Inisialisasi elemen UI
        titleTextView = view.findViewById(R.id.text_1)
        itemsRadioGroup = view.findViewById(R.id.radio_group_items)
        placeOrderButton = view.findViewById(R.id.buttonSave)

        // Set listener untuk tombol pesan
        placeOrderButton.setOnClickListener {
            // Panggil metode atau tindakan yang sesuai untuk memproses pesanan
            processOrder()
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener {
            // Ubah tampilan bottom sheet dialog
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(android.R.color.transparent)
        }
        return dialog
    }

    private fun processOrder() {
        // Implementasikan logika untuk memproses pesanan
        val selectedItem = itemsRadioGroup.findViewById<RadioButton>(itemsRadioGroup.checkedRadioButtonId)?.text

        // Lakukan tindakan yang sesuai dengan data pesanan
    }

    companion object {
        fun newInstance(): PesanSkrgActivity {
            return newInstance()
        }
    }
}
