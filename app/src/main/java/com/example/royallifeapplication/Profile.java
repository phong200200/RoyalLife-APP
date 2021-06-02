package com.example.royallifeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {
    TextInputLayout username,email,phoneN0,pass;
    TextView fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        fullname = findViewById(R.id.txtProfileUsername);
        email = findViewById(R.id.edtProfileEmail);
        phoneN0 = findViewById(R.id.edtProfilePhone);
        pass = findViewById(R.id.edtProfilePass);
        username = findViewById(R.id.edtProfileFullname);
        //show data
        showUser();
    }

    private void showUser() {
        Intent intent = getIntent();
        String fullnameDB = intent.getStringExtra("fullname");
        String emailDB = intent.getStringExtra("email");
        String phoneDB = intent.getStringExtra("phone");
        String passDB = intent.getStringExtra("pass");
        String userDB = intent.getStringExtra("username");

        fullname.setText(fullnameDB);
        email.getEditText().setText(emailDB);
        phoneN0.getEditText().setText(phoneDB);
        pass.getEditText().setText(passDB);
        username.getEditText().setText(userDB);
    }
}