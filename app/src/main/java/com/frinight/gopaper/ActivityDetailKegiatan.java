package com.frinight.gopaper;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDetailKegiatan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kegiatan);

        ImageView backButton = findViewById(R.id.back);

        backButton.setOnClickListener(v -> finish());
    }
}
