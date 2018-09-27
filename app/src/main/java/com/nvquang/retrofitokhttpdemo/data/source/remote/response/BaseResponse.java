package com.nvquang.retrofitokhttpdemo.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fs-sournary.
 * Date: 5/23/18.
 * Description:
 */

public class BaseResponse<T> {

    @Expose
    @SerializedName("code")
    private int mCode;
    @Expose
    @SerializedName("description")
    private String mMessages;
    @Expose
    @SerializedName("data")
    private T mData;

    public BaseResponse(T data) {
        mData = data;
    }

    public BaseResponse() {
    }

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessages;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
