package com.example.firebasechatapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.firebasechatapp.R;
import com.example.firebasechatapp.ui.adapter.ChatFragmentAdapter;
import com.example.firebasechatapp.ui.fragment.ChatFragment;
import com.example.firebasechatapp.ui.fragment.FriendFragment;
import com.google.android.material.tabs.TabLayout;

public class ChatActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ChatFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        viewPager = findViewById(R.id.viewpaper);
        tabLayout = findViewById(R.id.tablayout);

        fragmentAdapter = new ChatFragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFrament(new ChatFragment(), "Chats");
        fragmentAdapter.addFrament(new FriendFragment(), "Friends");

        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_message_black_24dp);
        tabLayout.getTabAt(0).setText("Chats");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_people_black_24dp);
        tabLayout.getTabAt(1).setText("Friends");
    }
}
