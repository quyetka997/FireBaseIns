package com.example.firebasechatapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firebasechatapp.R;
import com.example.firebasechatapp.model.InformationChat;
import com.example.firebasechatapp.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class MessengerActivity extends AppCompatActivity {

    private InformationChat informationChat;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        informationChat = new InformationChat();
        auth = FirebaseAuth.getInstance();
        if(bundle != null) {
            User user = (User) bundle.get("USER_SEND");
            informationChat.setmIdReceiver(user.getId());
            informationChat.setmIdSender(auth.getUid());
            informationChat.setmImageUrl(user.getImageUrl());
            informationChat.setmUsername(user.getUsername());

        }
        setContentView(R.layout.activity_messenger);
    }
}
