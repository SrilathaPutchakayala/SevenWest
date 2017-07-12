package com.sevenwest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
import com.sevenwest.dagger.DaggerDependency;
import com.sevenwest.dagger.Dependency;
import com.sevenwest.model.api.NetworkModule;
*/

import java.io.File;

import dagger.Module;
import dagger.Provides;

/**
 * Created by srilatha on 7/07/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
