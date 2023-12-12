package com.frinight.gopaper

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.frinight.gopaper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur inisialisasi text style menjadi bold
        setTextStyle(binding.tvHome, Typeface.BOLD)

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
            setInitialTextStyles()
            val intent = Intent(this, Pick_Up_Home::class.java)
            startActivity(intent)
        }

        binding.llProfile.setOnClickListener {
            handleNavigation(binding.llProfile, binding.tvProfile, FragmentProfile())
        }
    }

    private fun setInitialTextStyles() {
        setTextStyle(binding.tvHome, Typeface.NORMAL)
        setTextStyle(binding.tvCommunity, Typeface.NORMAL)
        setTextStyle(binding.tvEducation, Typeface.NORMAL)
        setTextStyle(binding.tvProfile, Typeface.NORMAL)
    }

    private fun handleNavigation(linearLayout: LinearLayout, textView: TextView, fragment: Fragment) {
        //Menghapus semua gaya teks sebelumnya
        setInitialTextStyles()

        // Mengatur gaya teks saat di klik menjadi bold
        setTextStyle(textView, Typeface.BOLD)

        replaceFragment(fragment)
    }

    private fun setTextStyle(textView: TextView, style: Int) {
        textView.setTypeface(null, style)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
