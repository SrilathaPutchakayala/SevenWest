package com.sevenwest.model.api;

import android.util.Log;

import com.sevenwest.model.channel.Channel;
import com.sevenwest.model.program.Program;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Srilatha on 7/7/16.
 */
public class Service {
    private final ServiceApi networkService;

    public Service(ServiceApi networkService) {
        this.networkService = networkService;
    }

    public Subscription getChannelList(final Service.GetCallBack callback) {

        return networkService.getChannelsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends Channel>>() {
                    @Override
                    public Observable<? extends Channel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<Channel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(Channel channelObj) {
                        callback.onSuccess(channelObj);

                    }
                });
    }

    public Subscription getChannelDetailsById(int channelId,final Service.GetCallBack callback) {

        String url = "channel_programs_"+channelId+".json";
        return networkService.getChannelsDetailsById(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends Program>>() {
                    @Override
                    public Observable<? extends Program> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<Program>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(Program channelObj) {
                        callback.onSuccess(channelObj);

                    }
                });
    }


    public interface GetCallBack{
        void onSuccess(Object channelObj);

        void onError(NetworkError networkError);
    }
}
