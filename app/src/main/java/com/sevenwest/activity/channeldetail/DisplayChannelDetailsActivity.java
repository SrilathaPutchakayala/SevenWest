package com.sevenwest.activity.channeldetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.sevenwest.activity.BaseActivity;
import com.sevenwest.R;
import com.sevenwest.app.GlobalApp;
import com.sevenwest.model.api.Service;
import com.sevenwest.model.program.Program;

import javax.inject.Inject;

/**
 * Created by srilatha on 7/07/2017.
 */

public class DisplayChannelDetailsActivity extends BaseActivity implements DisplayChannelDetailView {

    private ListView lv_programs_list;
    private ProgressBar progressBar;

    @Inject
    Service service;

    @Inject
    DisplayChannelDetailsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((GlobalApp) getApplication()).getAppComponent().inject(this);

        initResources();
    }

    private void initResources() {
        setContentView(R.layout.activity_channel_details);
        lv_programs_list = (ListView)findViewById(R.id.lv_programs_list);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            if(bundle.containsKey("CHANNEL_ID")){
                presenter.setView(this);
                presenter.setService(service);
                presenter.getProgramsListByChannelId(bundle.getInt("CHANNEL_ID"));
            }
        }
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
    public void getChannelDetailsByChannelId(Program programResponse) {

        ProgramsAdapter adapter = new ProgramsAdapter(programResponse.getProgramsList(), getApplicationContext());
        lv_programs_list.setAdapter(adapter);
    }
}
