package com.frinight.gopaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LanguageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var titleList: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        titleList = arrayOf(
            "English",
            "Afrikaans",
            "Albanian",
            "Amharic",
            "Arabic",
            "Armenian",
            "Azerbaijani",
            "Basque",
            "Belarusian",
            "Bengali",
            "Bosnian",
            "Bulgarian",
            "Cebuano",
            "Czech",
            "Chichewa",
            "Chinese (Simplified)",
            "Chinese (Traditional)",
            "Danish",
            "Esperanto",
            "Estonian",
            "Filipino",
            "Finnish",
            "Scottish Gaelic",
            "Galician",
            "Georgian",
            "Gujarati",
            "Hausa",
            "Hawaiian",
            "Hindi",
            "Hmong",
            "Hungarian",
            "Igbo",
            "Indonesian",
            "Irish",
            "Icelandic",
            "Italian",
            "Javanese",
            "Japanese",
            "German",
            "Kannada",
            "Catalan",
            "Kazakh",
            "Khmer",
            "Kyrgyz",
            "Korean",
            "Corsican",
            "Croatian",
            "Kurdish",
            "Lao",
            "Latin",
            "Latvian",
            "Lithuanian",
            "Luxembourgish",
            "Macedonian",
            "Slovenian",
            "Somali",
            "Spanish",
            "Sundanese",
            "Swahili",
            "Swedish",
            "Tagalog",
            "Tajik",
            "Tamil",
            "Telugu",
            "Thai",
            "Turkish",
            "Ukrainian",
            "Urdu",
            "Uzbek",
            "Vietnamese",
            "Welsh",
            "Xhosa",
            "Yoruba",
            "Greek",
            "Zulu"
        )
        recyclerView = findViewById(R.id.RecycleView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

        val btnbacklanguagetoprofile : ImageView = findViewById(R.id.btnbackfromlanguagetoprofile)
        btnbacklanguagetoprofile.setOnClickListener(this)

    }



    private fun getData(){
        for (i in titleList.indices) {
            val dataClass = DataClass(titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnbackfromlanguagetoprofile -> {
                val intent = Intent(this@LanguageActivity, FragmentProfile::class.java)
                startActivity(intent)
            }
        }
    }
}