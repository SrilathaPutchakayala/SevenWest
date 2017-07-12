package com.sevenwest.model.api;

import com.sevenwest.model.channel.Channel;
import com.sevenwest.model.program.Program;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by srilatha on 7/07/2017.
 */

public interface ServiceApi {

    @GET("channel_list.json")
    Observable<Channel> getChannelsList();

    //@GET("channel_programs_x.json")
    @GET("{channelDetailUrl}")
    Observable<Program> getChannelsDetailsById(@Path("channelDetailUrl") String url);

    /*@GET("/{nextPageUrl}")
    ReviewComment getProviderCommentsDetails(@EncodedPath("nextPageUrl") String nextPageUrl);*/
}
