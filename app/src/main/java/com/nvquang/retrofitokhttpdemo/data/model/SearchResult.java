package com.nvquang.retrofitokhttpdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by quangnv on 16/08/2018
 */

public class SearchResult implements Serializable {

    @SerializedName("total_count")
    @Expose
    private int mTotalCount;
    @SerializedName("incomplete_results")
    @Expose
    private boolean mIncompleteResults;
    @SerializedName("items")
    @Expose
    private List<User> mUsers;

    public int getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        mTotalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        mIncompleteResults = incompleteResults;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setUsers(List<User> users) {
        mUsers = users;
    }
}
