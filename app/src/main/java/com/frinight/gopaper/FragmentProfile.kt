package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aboutbtn: Button = view.findViewById(R.id.language)
        aboutbtn.setOnClickListener (this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.language -> {
                val intent = Intent(requireContext(), LanguageActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
