package com.zerocode.login_signup_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvSubtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.text_title);
        tvSubtitle = findViewById(R.id.text_subtitle);
        Intent intentExtra = getIntent();
        String email = intentExtra.getStringExtra(LoginActivity.EXTRA_EMAIL);
        String password = intentExtra.getStringExtra(LoginActivity.EXTRA_PASSWORD);
        tvTitle.setText(email);
        tvSubtitle.setText(password);
    }
}