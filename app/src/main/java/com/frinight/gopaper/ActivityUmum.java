package com.frinight.gopaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ActivityUmum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umum);

        ImageView backButton = findViewById(R.id.back);

        backButton.setOnClickListener(v -> finish());
    }
}