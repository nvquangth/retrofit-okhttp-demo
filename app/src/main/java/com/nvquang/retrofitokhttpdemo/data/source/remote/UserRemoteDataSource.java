package com.nvquang.retrofitokhttpdemo.data.source.remote;

import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;
import com.nvquang.retrofitokhttpdemo.data.source.UserDataSource;
import com.nvquang.retrofitokhttpdemo.data.source.remote.service.StackOverflowAPI;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by quangnv on 16/08/2018
 */

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {

    private StackOverflowAPI mAPI;

    @Inject
    public UserRemoteDataSource(StackOverflowAPI api) {
        mAPI = api;
    }

    @Override
    public Observable<SearchResult> searchUser(String q) {
        return mAPI.searchUsers(q);
    }
}
