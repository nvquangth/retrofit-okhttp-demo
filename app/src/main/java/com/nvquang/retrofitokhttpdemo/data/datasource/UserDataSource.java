package com.nvquang.retrofitokhttpdemo.data.datasource;

import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;

import io.reactivex.Observable;

/**
 * Created by quangnv on 16/08/2018
 */

public interface UserDataSource {

    interface RemoteDataSource extends UserDataSource {

        Observable<SearchResult> searchUser(String q);
    }
}
