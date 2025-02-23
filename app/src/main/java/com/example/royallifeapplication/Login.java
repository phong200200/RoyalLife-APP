package com.example.royallifeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity {
    private TextInputLayout userLogin, passLogin;
    private Button buttonLogin, buttonSignUp,forgot;
    private
    //FirebaseDatabase rootNode;
    DatabaseReference post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        post = FirebaseDatabase.getInstance().getReference().child("post");

        userLogin = findViewById(R.id.edtUsername);
        passLogin = findViewById(R.id.edtPassword);

        //fAuth = FirebaseAuth.getInstance();
        buttonLogin = findViewById(R.id.btnLogin);
        buttonSignUp = findViewById(R.id.btnCreate);

        String username = userLogin.getEditText().getText().toString().trim();
        String password = userLogin.getEditText().getText().toString().trim();
        //forgot
        forgot = findViewById(R.id.Forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateUsername() | !validatePassword()) {
                    return;
                } else {
                    final String usernameEntered = userLogin.getEditText().getText().toString();
                    final String passwordEntered = passLogin.getEditText().getText().toString();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
                    Query checkUser = reference.orderByChild("username").equalTo(usernameEntered);

                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {

                                userLogin.setError(null);
                                userLogin.setErrorEnabled(false);

                                String passDB = snapshot.child(usernameEntered).child("pass").getValue(String.class);

                                if (passDB.equals(passwordEntered)) {

                                    userLogin.setError(null);
                                    userLogin.setErrorEnabled(false);

                                    String fullnameDB = snapshot.child(usernameEntered).child("fullname").getValue(String.class);
                                    String emailDB = snapshot.child(usernameEntered).child("email").getValue(String.class);
                                    String phoneDB = snapshot.child(usernameEntered).child("phone").getValue(String.class);
                                    String userDB = snapshot.child(usernameEntered).child("username").getValue(String.class);
                                    //putdata

                                    //start menu
                                    Intent intent = new Intent(getApplication(), mmeennuu.class);
                                    intent.putExtra("fullname",fullnameDB);
                                    intent.putExtra("email",emailDB);
                                    intent.putExtra("phone",phoneDB);
                                    intent.putExtra("pass",passDB);
                                    intent.putExtra("username",userDB);
                                    startActivity(intent);
                                } else {
                                    passLogin.setError("Wrong password");
                                    passLogin.requestFocus();

                                }
                            } else {
                                userLogin.setError("not exist");
                                userLogin.requestFocus();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }
            }


        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validateUsername() {
        String val = userLogin.getEditText().getText().toString();
        if (val.isEmpty()) {
            userLogin.setError("Field cannot be empty");
            return false;
        } else {
            userLogin.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = passLogin.getEditText().getText().toString();
        if (val.isEmpty()) {
            passLogin.setError("Field cannot be empty");
            return false;
        } else {
            passLogin.setError(null);
            return true;
        }
    }
}