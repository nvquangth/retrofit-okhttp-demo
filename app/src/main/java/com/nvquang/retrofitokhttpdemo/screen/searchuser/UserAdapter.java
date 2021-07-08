package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nvquang.retrofitokhttpdemo.R;
import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.databinding.ItemUserBinding;
import com.nvquang.retrofitokhttpdemo.util.GlideApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quangnv on 21/08/2018
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemViewHolder> {

    private List<User> mUsers;
    private ItemClickListener mItemClickListener;

    public UserAdapter() {
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_user, parent, false);
        return new ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setUsers(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding mBinding;
        private ItemUserViewModel mItemUserViewModel;

        ItemViewHolder(ItemUserBinding binding, ItemClickListener itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemUserViewModel = new ItemUserViewModel(itemClickListener);
            mBinding.setViewModel(mItemUserViewModel);
        }

        private void bind(User user) {
            mItemUserViewModel.setUser(user);
            mBinding.executePendingBindings();
        }
    }

    public interface ItemClickListener {

        void onItemClick(User user);
    }
}
