package com.example.firebasechatapp.firebase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.firebasechatapp.model.User;
import com.example.firebasechatapp.ui.view.ChatActivity;
import com.example.firebasechatapp.ui.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;

public class AuthCommon {
    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;

    public AuthCommon(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabaseReference, FirebaseDatabase mFirebaseDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabaseReference = mDatabaseReference;
        this.mFirebaseDatabase = mFirebaseDatabase;
    }

    void changePass(String email, String newPassword) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.updatePassword(newPassword.toString().trim())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(mContext, "Password is updated!", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(MainActivity.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                            //progressBar.setVisibility(View.GONE);
                        }
                    }
                });


    }

    void changeEmail(String newEmail) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updateEmail(newEmail.toString().trim())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(mContext, "Email address is updated.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(mContext, "Failed to update email!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    void send(String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Toast.makeText(ResetPasswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(ResetPasswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }

                        //progressBar.setVisibility(View.GONE);
                    }
                });

    }

    public void SignIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Log.d("quyetka","SignIn Authentication Faild." + task.getException());

                } else {
                    Intent intent = new Intent(mContext, ChatActivity.class);
                    ((MainActivity)mContext).startActivity(intent);
                    ((MainActivity)mContext).finish();
                    Log.d("quyetka","SignIN Authentication successful." + task.getException());
                }
            }
        });
    }

    public void SignUp(String email, String password, final User user) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(mContext, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                            Log.d("quyetka","Authentication failed." + task.getException());
                        } else {
                            user.setId(mAuth.getUid());
                            mDatabaseReference.child("Users").child(user.getId()).setValue(user);
                            Log.d("quyetka","Authentication successful." + task.getException());
                            Intent intent = new Intent(mContext, ChatActivity.class);
                            ((MainActivity)mContext).startActivity(intent);
                            ((MainActivity)mContext).finish();
                        }
                    }
                });
    }

    void removeAccount() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.delete()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(mContext, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(mContext, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    void SignOut() {
        mAuth.signOut();

// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    //startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    //finish();
                }
            }
        };
    }

}
