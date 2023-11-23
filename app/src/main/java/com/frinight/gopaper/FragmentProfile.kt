package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment(R.layout.fragment_profile), View.OnClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val saldo: TextView = view.findViewById(R.id.saldo)
        val logout: TextView = view.findViewById(R.id.logout)

        saldo.setOnClickListener(this)
        logout.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.saldo -> {
                val intent = Intent(requireContext(), SaldoActivity::class.java)
                startActivity(intent)
            }

            R.id.logout -> {
                val intent = Intent(requireContext(), Login::class.java)
                startActivity(intent)
            }
        }
    }
}