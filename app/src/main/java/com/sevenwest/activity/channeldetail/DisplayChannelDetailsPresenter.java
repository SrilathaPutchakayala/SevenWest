package com.sevenwest.activity.channeldetail;

import com.sevenwest.model.api.Service;

/**
 * Created by srilatha on 9/07/2017.
 */

public interface DisplayChannelDetailsPresenter {

    void setService(Service service);

    void setView(DisplayChannelDetailView view);

    void getProgramsListByChannelId(int channelId);
}
