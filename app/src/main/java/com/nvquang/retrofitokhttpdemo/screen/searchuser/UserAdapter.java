package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nvquang.retrofitokhttpdemo.R;
import com.nvquang.retrofitokhttpdemo.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quangnv on 16/08/2018
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private LayoutInflater mInflater;
    private List<User> mUsers;

    public UserAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void setUsers(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageUser;
        private TextView mTextLogin;
        private TextView mTextScore;

        public UserViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            mImageUser = view.findViewById(R.id.image_user);
            mTextLogin = view.findViewById(R.id.text_login);
            mTextScore = view.findViewById(R.id.text_score);
        }

        private void bindData(User user) {
            Glide.with(itemView.getContext())
                    .load(user.getAvatarUrl())
                    .apply(RequestOptions.centerCropTransform())
                    .into(mImageUser);
            mTextLogin.setText(user.getLogin());
            mTextScore.setText(user.getScore() + "");
        }
    }
}
