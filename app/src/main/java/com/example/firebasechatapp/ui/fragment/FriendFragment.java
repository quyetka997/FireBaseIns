package com.example.firebasechatapp.ui.fragment;

import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebasechatapp.R;
import com.example.firebasechatapp.model.User;
import com.example.firebasechatapp.ui.adapter.UserAdaper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FriendFragment  extends Fragment implements UserAdaper.ItemListener {

    RecyclerView recyclerView;
    UserAdaper userAdaper;
    List<User> lUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend,container,false);

        recyclerView = view.findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        lUser = new ArrayList<>();
        userAdaper = new UserAdaper(lUser,getContext(),this);
        recyclerView.setAdapter(userAdaper);
        Log.d("quyetka",""+lUser.size());
        return view;
    }

    @Override
    public void onStart() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lUser.clear();
                for(DataSnapshot data: dataSnapshot.getChildren()) {
                    lUser.add(data.getValue(User.class));
                }
                Log.d("quyetka",""+lUser.size());
                if(userAdaper != null) {
                    userAdaper.notifyDataSetChanged();
                    Log.d("quyetka",""+lUser.size());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

    @Override
    public void onItemClickListener(User user) {

    }
}
