package com.example.firebasechatapp.model;

public class InformationChat {
    private String mIdSender;
    private String mIdReceiver;
    private String mContent;
    private String mUsername;
    private String mImageUrl;

    public InformationChat() {
    }

    public InformationChat(String mIdSender, String mIdReceiver, String mContent, String mUsername, String mImageUrl) {
        this.mIdSender = mIdSender;
        this.mIdReceiver = mIdReceiver;
        this.mContent = mContent;
        this.mUsername = mUsername;
        this.mImageUrl = mImageUrl;
    }

    public String getmIdSender() {
        return mIdSender;
    }

    public void setmIdSender(String mIdSender) {
        this.mIdSender = mIdSender;
    }

    public String getmIdReceiver() {
        return mIdReceiver;
    }

    public void setmIdReceiver(String mIdReceiver) {
        this.mIdReceiver = mIdReceiver;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
