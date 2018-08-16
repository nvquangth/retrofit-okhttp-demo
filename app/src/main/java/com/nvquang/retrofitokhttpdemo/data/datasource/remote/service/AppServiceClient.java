package com.nvquang.retrofitokhttpdemo.data.datasource.remote.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nvquang.retrofitokhttpdemo.util.Constant;

/**
 * Created by quangnv on 16/08/2018
 */

public class AppServiceClient extends ServiceClient {

    private static StackOverflowAPI sInstance;

    public static StackOverflowAPI getInstance(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = createService(context, Constant.END_POINT, StackOverflowAPI.class);
        }
        return sInstance;
    }
}
