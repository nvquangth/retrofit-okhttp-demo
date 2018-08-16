package com.nvquang.retrofitokhttpdemo.data.datasource.remote.service;

import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by quangnv on 16/08/2018
 */

public interface StackOverflowAPI {

    @GET("/search/users?sort=followers&order=desc")
    Call<SearchResult> searchUsers(@Query("q") String q);
}
