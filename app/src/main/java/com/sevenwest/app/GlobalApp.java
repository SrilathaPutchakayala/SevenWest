package com.sevenwest.app;

import android.app.Application;

import com.sevenwest.dagger.AppComponent;
import com.sevenwest.dagger.AppModule;
import com.sevenwest.dagger.DaggerAppComponent;
import com.sevenwest.model.api.NetworkModule;

import java.io.File;

/**
 * Created by srilatha on 9/07/2017.
 */

public class GlobalApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(GlobalApp application) {
        File cacheFile = new File(getCacheDir(), "responses");
        return DaggerAppComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .appModule(new AppModule(application))
                .build();
    }
}
