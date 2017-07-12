package com.sevenwest.activity.channeldetail;

import android.content.Context;

import com.sevenwest.app.GlobalApp;
import com.sevenwest.model.api.NetworkError;
import com.sevenwest.model.api.Service;
import com.sevenwest.model.program.Program;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by srilatha on 7/07/2017.
 */

public class DisplayChannelDetailsPresenterImpl implements DisplayChannelDetailsPresenter {

    Service service;
    DisplayChannelDetailView view;
    CompositeSubscription subscriptions;

    public DisplayChannelDetailsPresenterImpl(Context context) {
        ((GlobalApp)context).getAppComponent().inject(this);
        this.subscriptions = new CompositeSubscription();
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }

    @Override
    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void setView(DisplayChannelDetailView view) {
        this.view = view;
    }

    @Override
    public void getProgramsListByChannelId(int channelId) {
        view.showWait();

        Subscription subscription = service.getChannelDetailsById(channelId,new Service.GetCallBack() {
            @Override
            public void onSuccess(Object channelResponse) {
                view.removeWait();
                view.getChannelDetailsByChannelId((Program) channelResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
}
