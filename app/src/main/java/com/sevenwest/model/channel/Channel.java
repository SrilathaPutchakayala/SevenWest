package com.sevenwest.model.channel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by srilatha on 6/07/2017.
 */


public class Channel {

    @SerializedName("name")
    @Expose
    String channelName;

    @SerializedName("channelId")
    @Expose
    int channelId;

    @SerializedName("displayOrder")
    @Expose
    int displayOrder;

    @SerializedName("channels")
    @Expose
    private List<Channel> channelsList = new ArrayList<Channel>();

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public List<Channel> getChannelsList() {

        if (channelsList!=null && channelsList.size() > 1) {
            Collections.sort(channelsList, new Comparator<Channel>() {
                @Override
                public int compare(final Channel object1, final Channel object2) {
                    return new Integer(object1.getDisplayOrder()).compareTo(new Integer(object2.getDisplayOrder()));
                }
            });
        }
        return channelsList;
    }

    public void setChannelsList(List<Channel> channelsList) {
        this.channelsList = channelsList;
    }
}
