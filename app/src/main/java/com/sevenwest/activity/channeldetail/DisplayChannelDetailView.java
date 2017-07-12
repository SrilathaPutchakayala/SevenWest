package com.sevenwest.activity.channeldetail;

import com.sevenwest.model.program.Program;

/**
 * Created by srilatha on 7/07/2017.
 */

public interface DisplayChannelDetailView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getChannelDetailsByChannelId(Program programsResponse);
}
