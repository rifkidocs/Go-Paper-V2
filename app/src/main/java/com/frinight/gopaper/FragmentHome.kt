package com.frinight.gopaper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.frinight.gopaper.data.AppDatabase
import com.frinight.gopaper.data.dao.UserDao
import com.frinight.gopaper.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentHome : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var userDao: UserDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        userDao = AppDatabase.getInstance(requireContext()).userDao()

        val btnPickupNow: Button = view.findViewById(R.id.btnPickupNow)
        val notif: ImageView = view.findViewById(R.id.notif)

        btnPickupNow.setOnClickListener {
            val intent = Intent(activity, Pick_Up_Home::class.java)
            startActivity(intent)
        }
        notif.setOnClickListener {
            val intent = Intent(activity, Notifikasi_Activity::class.java)
            startActivity(intent)
        }

        loadUserFullName()
    }

    private fun loadUserFullName() {
        val userId = getLoggedInUserId()
        if (userId != -1L) {
            GlobalScope.launch {
                val fullName = userDao.getFullName(userId)
                updateGreetingText(fullName)
            }
        }
    }

    private fun getLoggedInUserId(): Long {
        val sharedPreferences = requireContext().getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getLong("userId", -1L)
    }

    private fun updateGreetingText(fullName: String?) {
        requireActivity().runOnUiThread {
            val greetingTextView: TextView = binding.fullName
            if (!fullName.isNullOrBlank()) {
                greetingTextView.text = "Hi, $fullName"
            }
        }
    }
}
