package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user_name;
    EditText Pwd;
    Button log_in;
    Button sign_up;
    final String CREDENTIAL_SHARED_PREF="our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name= findViewById(R.id.user);
        Pwd=    findViewById(R.id.pass);
        sign_up= findViewById(R.id.signup_btn);
        log_in= findViewById(R.id.login_btn);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpactivity.class);
                startActivity(intent);
            }
        });
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUsername = credentials.getString("Username",null);
                String strPassword = credentials.getString("Password",null);
                String userN = user_name.getText().toString();
                String pass_word =Pwd.getText().toString() ;

                if (strUsername!=null && userN!=null && strUsername.equalsIgnoreCase(userN)){
                    if (strPassword!=null && pass_word!=null && strPassword.equalsIgnoreCase(pass_word)) {
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText (MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}