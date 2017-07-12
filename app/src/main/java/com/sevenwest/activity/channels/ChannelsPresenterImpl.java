package com.sevenwest.activity.channels;

import android.content.Context;
import android.util.Log;

import com.sevenwest.app.GlobalApp;
import com.sevenwest.model.api.NetworkError;
import com.sevenwest.model.api.Service;
import com.sevenwest.model.api.ServiceApi;
import com.sevenwest.model.channel.Channel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by srilatha on 7/07/2017.
 */

public class ChannelsPresenterImpl implements ChannelsPresenter {

    Service service;
    ChannelsView view;
    CompositeSubscription subscriptions;

    public ChannelsPresenterImpl(Context context) {
        ((GlobalApp) context).getAppComponent().inject(this);
        this.subscriptions = new CompositeSubscription();
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }

    @Override
    public void setView(ChannelsView view) {
        this.view = view;
    }

    @Override
    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void getChannelsList() {
        view.showWait();

        Subscription subscription = service.getChannelList(new Service.GetCallBack() {
            @Override
            public void onSuccess(Object channelResponse) {
                view.removeWait();
                view.getListOfChannels((Channel)channelResponse);
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
