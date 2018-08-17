package com.nvquang.retrofitokhttpdemo.data.datasource.remote;

import android.content.Context;
import android.util.Log;

import com.nvquang.retrofitokhttpdemo.data.datasource.UserDataSource;
import com.nvquang.retrofitokhttpdemo.data.datasource.remote.service.AppServiceClient;
import com.nvquang.retrofitokhttpdemo.data.datasource.remote.service.StackOverflowAPI;
import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;
import com.nvquang.retrofitokhttpdemo.data.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by quangnv on 16/08/2018
 */

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {

    private static UserRemoteDataSource sInstance;
    private StackOverflowAPI mAPI;

    private UserRemoteDataSource(StackOverflowAPI api) {
        mAPI = api;
    }

    public static synchronized UserRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new UserRemoteDataSource(AppServiceClient.getInstance(context));
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public Observable<SearchResult> searchUser(String q) {
        return mAPI.searchUsers(q);
    }
}
