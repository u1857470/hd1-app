package com.example.hd1app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        configureRegisterPage();
    }

    private void configureRegisterPage(){
        Button registerPage = (Button) findViewById(R.id.registerPage);
        registerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFragment.this, RegisterFragment.class));

                configureLoginPageButton();
            }
        });}

    private void configureLoginPageButton() {
        Button loginPageButton = (Button) findViewById(R.id.loginPageButton);
        loginPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFragment.this, HomePage.class));
            }
        });
    }
}

