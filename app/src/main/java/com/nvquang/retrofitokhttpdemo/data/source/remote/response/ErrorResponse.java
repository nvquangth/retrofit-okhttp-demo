package com.nvquang.retrofitokhttpdemo.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nvquang.retrofitokhttpdemo.data.model.ErrorMessage;

import java.util.Locale;

/**
 * Created by fs-sournary.
 * Date: 5/23/18.
 * Description:
 */
public class ErrorResponse {
    @Expose
    private int mCode;
    @Expose
    private String mMessages;
    @Expose
    @SerializedName("data")
    private ErrorMessage mErrorMessage;

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        if (mErrorMessage != null
                && mErrorMessage.getMessages() != null
                && mErrorMessage.getMessages().size() != 0) {
            return mMessages.toUpperCase(Locale.getDefault())
                    + "\n"
                    + mErrorMessage.getMessageList();
        }
        return mMessages;
    }
}
