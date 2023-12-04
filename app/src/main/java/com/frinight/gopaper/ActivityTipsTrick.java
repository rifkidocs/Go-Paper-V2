package com.frinight.gopaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ActivityTipsTrick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_trick);

        ImageView backButton = findViewById(R.id.back);

        backButton.setOnClickListener(v -> finish());
    }
}