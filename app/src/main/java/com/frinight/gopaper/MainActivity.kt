package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.frinight.gopaper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur inisialisasi textcolor
        setTextColor(binding.tvHome, ContextCompat.getColor(this, R.color.colorSelected))

        // Membuka FragmentHome saat di inisialisasi
        replaceFragment(FragmentHome())

        binding.llHome.setOnClickListener {
            handleNavigation(binding.llHome, binding.tvHome, FragmentHome())
        }

        binding.llCommunity.setOnClickListener {
            handleNavigation(binding.llCommunity, binding.tvCommunity, FragmentCommunity())
        }

        binding.llEducation.setOnClickListener {
            handleNavigation(binding.llEducation, binding.tvEducation, FragmentEducation())
        }

        binding.ivPickup.setOnClickListener {
            setInitialTextColors()
            val intent = Intent(this, Pick_Up_Home::class.java)
            startActivity(intent)
        }

        binding.llProfile.setOnClickListener {
            handleNavigation(binding.llProfile, binding.tvProfile, FragmentProfile())
        }
    }

    private fun setInitialTextColors() {
        setTextColor(binding.tvHome, ContextCompat.getColor(this, R.color.colorUnselected))
        setTextColor(binding.tvCommunity, ContextCompat.getColor(this, R.color.colorUnselected))
        setTextColor(binding.tvEducation, ContextCompat.getColor(this, R.color.colorUnselected))
        setTextColor(binding.tvProfile, ContextCompat.getColor(this, R.color.colorUnselected))
    }

    private fun handleNavigation(linearLayout: LinearLayout, textView: TextView, fragment: Fragment) {
        //Menghapus semua warna
        setInitialTextColors()

        // Mengatur warna text saat di klik
        setTextColor(textView, ContextCompat.getColor(this, R.color.colorSelected))

        replaceFragment(fragment)
    }

    private fun setTextColor(textView: TextView, color: Int) {
        textView.setTextColor(color)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
