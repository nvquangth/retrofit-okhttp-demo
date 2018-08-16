package com.nvquang.retrofitokhttpdemo.data.datasource;

import com.nvquang.retrofitokhttpdemo.data.model.User;

import java.util.List;

/**
 * Created by quangnv on 16/08/2018
 */

public interface UserDataSource {

    interface Callback<T> {

        void onStartLoading();

        void onLoaded(T data);

        void onDataNotAvailable(Exception e);

        void onComplete();
    }

    interface RemoteDataSource extends UserDataSource {

        void searchUser(String q, Callback<List<User>> callback);
    }
}
