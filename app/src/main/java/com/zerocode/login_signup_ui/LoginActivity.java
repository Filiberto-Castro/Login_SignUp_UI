package com.zerocode.login_signup_ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private CheckBox cbTerms;
    private TextView mReplyText;
    public static final String EXTRA_EMAIL = "com.zerocode.login_signup_ui.extra.EMAIL";
    public static final String EXTRA_PASSWORD = "com.zerocode.login_signup_ui.extra.PASSWORD";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.editText_email);
        etPassword = findViewById(R.id.editText_password);
        cbTerms = findViewById(R.id.checkBox);
        mReplyText = findViewById(R.id.mReplyText);
    }

    public void btnSignUp(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty() && cbTerms.isChecked()){
            Intent intentLogin = new Intent(this, MainActivity.class);
            intentLogin.putExtra(EXTRA_EMAIL, email);
            intentLogin.putExtra(EXTRA_PASSWORD, password);
            startActivityForResult(intentLogin, TEXT_REQUEST);
        }else{
            Toast.makeText(this, "Complete the information", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity.EXTRA_REPLY);
                mReplyText.setText(reply);
                mReplyText.setVisibility(View.VISIBLE);
            }
        }

    }
}