package com.sevenwest.activity.channels;

import com.sevenwest.model.api.Service;

/**
 * Created by srilatha on 9/07/2017.
 */

public interface ChannelsPresenter {

    void setView(ChannelsView view);

    void setService(Service service);

    void getChannelsList();

}
