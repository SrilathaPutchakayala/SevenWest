package com.sevenwest.activity.channels;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.sevenwest.activity.BaseActivity;
import com.sevenwest.R;
import com.sevenwest.activity.channeldetail.DisplayChannelDetailsActivity;
import com.sevenwest.app.GlobalApp;
import com.sevenwest.model.api.Service;
import com.sevenwest.model.channel.Channel;

import javax.inject.Inject;

/**
 * Created by srilatha on 7/07/2017.
 */

public class ChannelsListActivity extends BaseActivity implements ChannelsView,AdapterView.OnItemClickListener {

    private ListView lv_channels_list;
    private ProgressBar progressBar;

    @Inject
    public Service service;

    @Inject
    ChannelsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((GlobalApp) getApplication()).getAppComponent().inject(this);

        initResources();

        presenter.setView(this);
        presenter.setService(service);
        presenter.getChannelsList();

    }

    private void initResources() {

        setContentView(R.layout.activity_channels_list);

        lv_channels_list = (ListView) findViewById(R.id.lv_channels_list);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        //set listener
        lv_channels_list.setOnItemClickListener(this);
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getListOfChannels(Channel channelResponse) {

        ChannelsAdapter adapter = new ChannelsAdapter(channelResponse.getChannelsList(), getApplicationContext());
        lv_channels_list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Channel channelObj = (Channel) adapterView.getItemAtPosition(i);

        Intent displayChannelIntent = new Intent(ChannelsListActivity.this, DisplayChannelDetailsActivity.class);
        displayChannelIntent.putExtra("CHANNEL_ID",channelObj.getChannelId());
        startActivity(displayChannelIntent);

    }
}
