package com.example.jsontest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context localContext;
    private List<User> localUsers;

    public UserAdapter(Context context, List<User> users) {
        this.localContext = context;
        this.localUsers = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User u = localUsers.get(position);
        Picasso.with(localContext)
                .load(u.avatar_url)
                .into(holder.ivAvatar);
        holder.tvLoginName.setText(u.login);
        holder.tvId.setText(String.valueOf(u.id));
    }

    @Override
    public int getItemCount() {
        return localUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvLoginName;
        TextView tvId;
        ImageView ivAvatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLoginName = itemView.findViewById(R.id.tv_login_name);
            tvId = itemView.findViewById(R.id.tv_id);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
