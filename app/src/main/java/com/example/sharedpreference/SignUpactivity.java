package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpactivity extends AppCompatActivity {
    EditText user_name;
    EditText Pwd;
    EditText confirm_pwd;
    Button btn_Create_user;
    final String CREDENTIAL_SHARED_PREF="our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        user_name= findViewById(R.id.user);
        Pwd=    findViewById(R.id.pass);
        confirm_pwd = findViewById (R.id.confirm_pass);
        btn_Create_user =  findViewById(R.id.createUser_btn);
        btn_Create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         String strPassword= Pwd.getText().toString();
         String strConfirmPassword= confirm_pwd.getText().toString();
         String strUsername= user_name.getText().toString();
                if (strPassword!=null && strConfirmPassword!=null && strPassword.equalsIgnoreCase(strConfirmPassword))
                {
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor= credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("Username", strUsername);
                    editor.commit();

                    SignUpactivity.this.finish();



                }


            }
        });

    }
}