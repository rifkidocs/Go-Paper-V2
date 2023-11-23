package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentHome : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPickupNow: Button = view.findViewById(R.id.btnPickupNow)

        btnPickupNow.setOnClickListener {
            val intent = Intent(activity, Pick_Up_Home::class.java)
            startActivity(intent)
        }
    }
}
