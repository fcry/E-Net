package com.example.user.mysplashscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Button BtnLogin;
    EditText Username, Password;
    SharedPreferences sharedpref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedpref = Login.this.getPreferences(Context.MODE_PRIVATE);
        if(sharedpref.contains("username")) {
            //langsung masuk ke intent
            Intent intent = new Intent(Login.this,Home.class);
            intent.putExtra("username", sharedpref.getString("username", "none"));
            startActivity(intent);
            finish();
        }else{
        }
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        BtnLogin = (Button)findViewById(R.id.btnLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = Username.getText().toString();
                String passwordKey = Password.getText().toString();
                if (usernameKey.equals("admin") && passwordKey.equals("admin")) {
                    Intent intent = new Intent(Login.this,Home.class);
                    intent.putExtra("username", usernameKey);
                    editor = sharedpref.edit();
                    editor.putString("username", usernameKey);
                    editor.commit();
                    startActivity(intent);
                    finish();
                }else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }

        });

    }
}
