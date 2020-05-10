package com.example.firebasechatapp.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ChatFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> lFragment;
    private List<String> lTittle;

    public ChatFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        lFragment = new ArrayList<>();
        lTittle = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lFragment.get(position);
    }

    @Override
    public int getCount() {
        return lFragment.size();
    }

    public void addFrament(Fragment fragment,String tittle) {
        lFragment.add(fragment);
        lTittle.add(tittle);
    }


}
