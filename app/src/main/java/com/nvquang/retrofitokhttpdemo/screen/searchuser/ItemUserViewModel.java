package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.util.GlideApp;

/**
 * Created by quangnv on 21/08/2018
 */

public class ItemUserViewModel {

    public ObservableField<User> userObservableField = new ObservableField<>();
    private UserAdapter.ItemClickListener mItemClickListener;

    public ItemUserViewModel(UserAdapter.ItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setUser(User user) {
        userObservableField.set(user);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadUrl(ImageView image, String url) {
        GlideApp.with(image.getContext())
                .load(url)
                .circleCrop()
                .into(image);
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null || userObservableField.get() == null) {
            return;
        }
        mItemClickListener.onItemClick(userObservableField.get());
    }
}
