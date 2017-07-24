package com.example.phuwarin.grand.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Phuwarin on 2/16/2017.
 */

public class MessageDao {
    @SerializedName("behavior") private String behavior;
    @SerializedName("time_stamp") private String timeStamp;

    public MessageDao() {
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
