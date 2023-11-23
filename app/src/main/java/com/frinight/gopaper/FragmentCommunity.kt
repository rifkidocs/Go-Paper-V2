package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentCommunity : Fragment(R.layout.fragment_community), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val umum: TextView = view.findViewById(R.id.tv_umum)
        val kegiatan: TextView = view.findViewById(R.id.tv_kegiatan)
        val tipstrick: TextView = view.findViewById(R.id.tipstrick)
        val k1: ImageView = view.findViewById(R.id.k1)

        umum.setOnClickListener(this)
        kegiatan.setOnClickListener(this)
        tipstrick.setOnClickListener(this)
        k1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_umum -> {
                val intent = Intent(requireContext(), ActivityUmum::class.java)
                startActivity(intent)
            }

            R.id.tv_kegiatan -> {
                val intent = Intent(requireContext(), ActivityKegiatan::class.java)
                startActivity(intent)
            }

            R.id.tipstrick -> {
                val intent = Intent(requireContext(), ActivityTipsTrick::class.java)
                startActivity(intent)
            }

            R.id.k1 -> {
                val intent = Intent(requireContext(), ActivityDetailKegiatan::class.java)
                startActivity(intent)
            }
        }
    }
}
