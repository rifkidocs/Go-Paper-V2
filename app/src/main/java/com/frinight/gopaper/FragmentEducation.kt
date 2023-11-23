package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentEducation:Fragment(R.layout.fragment_education), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artikel1: View = view.findViewById(R.id.background2)

        artikel1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.background2 -> {
                val intent = Intent(requireContext(), ArtikelEdukasi1::class.java)
                startActivity(intent)
            }
        }
    }
}