package com.example.firebasechatapp.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;

public class FireBaseDBCommon {

    private DatabaseReference mDatabaseReference;

    public FireBaseDBCommon(DatabaseReference mDatabaseReference) {
        this.mDatabaseReference = mDatabaseReference;
    }

    public void insertData(Object t,String userID) {
        mDatabaseReference.child(userID).setValue(t);
    }

    public List<Object> readData(String userID) {
        mDatabaseReference.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //format Data
                //User user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return null;
    }

    void updateData(Object T,String userID,String oject) {
        mDatabaseReference.child(oject).child(userID).child("Object").setValue(T);
    }

    void deleteData(String userID,String oject) {
        mDatabaseReference.child(oject).child(userID).removeValue();
    }
}
