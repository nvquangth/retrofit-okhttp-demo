package com.nvquang.retrofitokhttpdemo.data.datasource.remote.service;

import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by quangnv on 16/08/2018
 */

public interface StackOverflowAPI {

    @GET("/search/users?sort=followers&order=desc")
    Observable<SearchResult> searchUsers(@Query("q") String q);
}
