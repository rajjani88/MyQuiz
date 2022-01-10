package com.raj.myquiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raj.myquiz.R;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    TextView tvReg, tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();


    }

    //all find view by ids
    void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);
        tvError = findViewById(R.id.tvError);

        //
        getSupportActionBar().setTitle("Login to Quiz");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                //user input validate
                if (userInputValidate(email, password)) {
                    showMessage("Proceed to Login");
                }
            }
        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Lets Create Account");
                gotoReg();
            }
        });

    }


    boolean userInputValidate(String email, String password) {
        boolean isSuccess = true;
        if (email.isEmpty()) {
            tvError.setText("Email is empty");
            isSuccess = false;
        }

        if (password.isEmpty()) {
            tvError.setText("Password is Empty");
            isSuccess = false;
        }

        return isSuccess;
    }


    void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    //goto next page
    void gotoReg() {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

}