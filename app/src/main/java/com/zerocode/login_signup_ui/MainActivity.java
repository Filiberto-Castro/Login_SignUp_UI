package com.zerocode.login_signup_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.zerocode.login_signup_ui.extra.REPLY";
    private TextView tvTitle;
    private TextView tvSubtitle;
    private EditText etReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.text_title);
        tvSubtitle = findViewById(R.id.text_subtitle);
        etReply = findViewById(R.id.editTextReplay);
        Intent intentExtra = getIntent();
        String email = intentExtra.getStringExtra(LoginActivity.EXTRA_EMAIL);
        String password = intentExtra.getStringExtra(LoginActivity.EXTRA_PASSWORD);
        tvTitle.setText(email);
        tvSubtitle.setText(password);
    }

    public void btnReply(View view) {
        // devolviendo datos a la actividad principal
        String textReplay = etReply.getText().toString();
        Intent reply = new Intent();
        reply.putExtra(EXTRA_REPLY, textReplay);
        setResult(RESULT_OK, reply);
        finish();

    }
}