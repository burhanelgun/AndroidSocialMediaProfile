package com.example.challange3.models;

import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("feed")
    @Expose
    private ArrayList<FeedItemModel> feed = null;
    @SerializedName("feedTotal")
    @Expose
    private Integer feedTotal;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<FeedItemModel> getFeed() {
        return feed;
    }

    public void setFeed(ArrayList<FeedItemModel> feed) {
        this.feed = feed;
    }

    public Integer getFeedTotal() {
        return feedTotal;
    }

    public void setFeedTotal(Integer feedTotal) {
        this.feedTotal = feedTotal;
    }

    public ArrayList<FeedItemModel> getFeedByPopularity(){
        Collections.sort(feed,new FeedItemModel.FeedByPopularityComparator());
        return feed;
    }

    public ArrayList<FeedItemModel> getFeedByTime(){
        Collections.sort(feed,new FeedItemModel.FeedByTimeComparator());
        return feed;
    }

}