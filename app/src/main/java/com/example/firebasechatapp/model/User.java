package com.example.firebasechatapp.model;

import java.io.Serializable;

public class User implements Serializable {

    private String mId;
    private String mUsername;
    private String mPassword;
    private String mEmail;
    private String mImageUrl;

    public User() {
    }

    public User(String mId, String mUsername, String mPassword, String mEmail, String mImageUrl) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mImageUrl = mImageUrl;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }
}
