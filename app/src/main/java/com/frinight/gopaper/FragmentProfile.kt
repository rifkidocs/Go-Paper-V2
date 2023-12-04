package com.frinight.gopaper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment(R.layout.fragment_profile), View.OnClickListener {
    private lateinit var emailTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val saldo: TextView = view.findViewById(R.id.saldo)
        val logout: TextView = view.findViewById(R.id.logout)
        emailTextView = view.findViewById(R.id.email)

        saldo.setOnClickListener(this)
        logout.setOnClickListener(this)

        // Memanggil metode untuk mengisi email dari SharedPreferences
        loadUserEmail()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.saldo -> {
                // Implementasi logika ketika tombol saldo ditekan
                val intent = Intent(requireContext(), SaldoActivity::class.java)
                startActivity(intent)
            }

            R.id.logout -> {
                // Implementasi logika ketika tombol logout ditekan
                performLogout()
            }
        }
    }

    private fun performLogout() {
        // Hapus informasi login dari SharedPreferences
        val sharedPreferences =
            requireContext().getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()

        // Pindah ke layar login setelah logout
        val intent = Intent(requireContext(), Login::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun loadUserEmail() {
        // Memuat email dari SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        val userEmail = sharedPreferences.getString("email", "")

        // Menetapkan nilai email ke TextView
        emailTextView.text = userEmail
    }
}
