package com.nvquang.retrofitokhttpdemo.data.model;

import java.util.List;

/**
 * Created by fs-sournary.
 * Date: 5/23/18.
 * Description:
 */

public class ErrorMessage {

    private List<String> mMessageList;

    public List<String> getMessages() {
        return mMessageList;
    }

    public String getMessageList() {
        String listMessage = "";
        for (String message : mMessageList) {
            listMessage += "\n" + "-" + message;
        }
        return listMessage;
    }
}
