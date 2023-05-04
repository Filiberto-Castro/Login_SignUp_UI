package com.zerocode.login_signup_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private CheckBox cbTerms;
    public static final String EXTRA_EMAIL = "com.zerocode.login_signup_ui.extra.EMAIL";
    public static final String EXTRA_PASSWORD = "com.zerocode.login_signup_ui.extra.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.editText_email);
        etPassword = findViewById(R.id.editText_password);
        cbTerms = findViewById(R.id.checkBox);
    }

    public void btnSignUp(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty() && cbTerms.isChecked()){
            Intent intentLogin = new Intent(this, MainActivity.class);
            intentLogin.putExtra(EXTRA_EMAIL, email);
            intentLogin.putExtra(EXTRA_PASSWORD, password);
            startActivity(intentLogin);
        }else{
            Toast.makeText(this, "Complete the information", Toast.LENGTH_SHORT).show();
        }
    }
}