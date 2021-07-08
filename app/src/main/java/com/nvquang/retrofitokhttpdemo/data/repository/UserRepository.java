package com.nvquang.retrofitokhttpdemo.data.repository;

import com.nvquang.retrofitokhttpdemo.data.datasource.UserDataSource;
import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;
import com.nvquang.retrofitokhttpdemo.data.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by quangnv on 16/08/2018
 */

public class UserRepository implements UserDataSource.RemoteDataSource {

    private static UserRepository sInstance;
    private UserDataSource.RemoteDataSource mRemoteDataSource;

    private UserRepository(RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static synchronized UserRepository getInstance(RemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new UserRepository(remoteDataSource);
        }
        return sInstance;
    }

    @Override
    public Observable<SearchResult> searchUser(String q) {
        return mRemoteDataSource.searchUser(q);
    }
}
