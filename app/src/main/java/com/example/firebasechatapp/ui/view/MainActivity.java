package com.example.firebasechatapp.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firebasechatapp.R;
import com.example.firebasechatapp.firebase.AuthCommon;
import com.example.firebasechatapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText txtEmail, txtPassword, txtUsername ;
    Button btnSignin, btnSignup;
    AuthCommon authCommon;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtUsername = findViewById(R.id.txtUsername);

        btnSignin = findViewById(R.id.btn_signin);
        btnSignup = findViewById(R.id.btn_signup);

        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        authCommon = new AuthCommon(this, auth,databaseReference,firebaseDatabase);

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, ChatActivity.class));
            finish();
        }
    }
    @Override
    public void onClick(View v) {
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String username = txtUsername.getText().toString().trim();

        User user = new User("",username,password,email,"default");
        switch (v.getId()) {
            case R.id.btn_signin:
                authCommon.SignIn(email,password);
                break;
            case R.id.btn_signup:
                authCommon.SignUp(email, password,user);
                break;
            default:
                break;

        }

    }
}
