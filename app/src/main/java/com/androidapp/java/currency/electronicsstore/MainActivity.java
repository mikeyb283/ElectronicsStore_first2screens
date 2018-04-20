package com.androidapp.java.currency.electronicsstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public enum LoginSuccess {
        login(1),
        password(2),
        success(0);

        private int intValue;

        LoginSuccess(int value) {
            intValue = value;
        }

        public int getIntValue() {
            return intValue;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final TextView userLogin = (TextView) findViewById(R.id.userNameEntry);
        final TextView txtPassword = (TextView) findViewById(R.id.passwordEntry);
        Button nextButton = (Button) findViewById(R.id.loginButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastError = null;
                LoginSuccess isOK = null;

                switch (CheckLogin(userLogin.getText().toString(), txtPassword.getText().toString())) {
                    case login:
                        toastError.makeText(getApplicationContext(), getString(R.string.errMessageLogin), toastError.LENGTH_SHORT).show();
                        userLogin.requestFocus();
                        break;
                    case password:
                        toastError.makeText(getApplicationContext(), getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show();
                        txtPassword.requestFocus();
                        break;
                    default:
                        startActivity(new Intent(MainActivity.this, ProductSelectionActivity.class));
                        break;
                }


            }

        });


    }


    LoginSuccess CheckLogin(String txtLogin, String txtPassword) {
        String holdLogin = "Mike";
        String holdPass = "password";

        if (!(holdLogin.equals(txtLogin))) {
            return LoginSuccess.login;
        }

        if (!(holdPass.equals(txtPassword))) {
            return LoginSuccess.password;
        }

        return LoginSuccess.success;
    }

}
