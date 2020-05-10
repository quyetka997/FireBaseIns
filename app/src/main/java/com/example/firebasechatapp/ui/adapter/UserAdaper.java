package com.example.firebasechatapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firebasechatapp.R;
import com.example.firebasechatapp.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdaper extends RecyclerView.Adapter<UserAdaper.UserViewHolder> {

    List<User> lUser;
    Context context;
    ItemListener itemListener;

    public UserAdaper(List<User> lUser, Context context, ItemListener itemListener) {
        this.lUser = lUser;
        this.context = context;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_friend,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setData(lUser.get(position),position);
    }

    @Override
    public int getItemCount() {
        return lUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        int curPosition;
        public TextView txtUsername;

        public void setData(User user,int position) {
            txtUsername.setText(user.getUsername());
            curPosition = position;
        }

        public UserViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtUsername = itemView.findViewById(R.id.txtUsername);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemListener != null) {
                        itemListener.onItemClickListener(lUser.get(curPosition));
                    }
                }
            });
        }



    }

    public interface ItemListener{
        void onItemClickListener(User user);
    }
}
