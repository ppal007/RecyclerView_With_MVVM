package com.ppal007.recyclerview_with_mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ppal007.recyclerview_with_mvvm.R;
import com.ppal007.recyclerview_with_mvvm.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sample_recycler_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);
        holder.name.setText(users[position].getLogin());
        holder.id.setText(String.valueOf(users[position].getId()));

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textViewName);
            id = itemView.findViewById(R.id.textViewId);

        }
    }
}
