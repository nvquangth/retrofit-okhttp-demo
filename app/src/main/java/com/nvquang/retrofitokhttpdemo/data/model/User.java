package com.nvquang.retrofitokhttpdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("login")
    @Expose
    private String mLogin;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("node_id")
    @Expose
    private String mNodeId;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    private String mGravatarId;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("html_url")
    @Expose
    private String mHtmlUrl;
    @SerializedName("followers_url")
    @Expose
    private String mFollowersUrl;
    @SerializedName("following_url")
    @Expose
    private String mFollowingUrl;
    @SerializedName("gists_url")
    @Expose
    private String mGistsUrl;
    @SerializedName("starred_url")
    @Expose
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;
    @SerializedName("events_url")
    @Expose
    private String mEventsUrl;
    @SerializedName("received_events_url")
    @Expose
    private String mReceivedEventsUrl;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("site_admin")
    @Expose
    private boolean mSiteAdmin;
    @SerializedName("score")
    @Expose
    private float mScore;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String nodeId) {
        mNodeId = nodeId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public boolean isSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
    }

    public float getScore() {
        return mScore;
    }

    public void setScore(float score) {
        mScore = score;
    }
}