package com.sevenwest.activity.channels;

import com.sevenwest.model.channel.Channel;

/**
 * Created by srilatha on 7/07/2017.
 */

public interface ChannelsView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getListOfChannels(Channel channelResponse);
}
