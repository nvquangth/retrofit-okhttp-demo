package com.nvquang.retrofitokhttpdemo.data.source.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInRequest extends BaseRequest {
    @Expose
    @SerializedName("email")
    private String mEmail;
    @Expose
    @SerializedName("password")
    private String mPassword;

    public SignInRequest(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }
}
