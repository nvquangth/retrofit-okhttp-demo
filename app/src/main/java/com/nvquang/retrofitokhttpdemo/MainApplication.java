package com.nvquang.retrofitokhttpdemo;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.nvquang.retrofitokhttpdemo.data.source.remote.service.NetworkModule;
import com.nvquang.retrofitokhttpdemo.util.rx.SchedulerModule;

/**
 * Created by quangnv on 26/09/2018
 */

public class MainApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .applicationModule(new ApplicationModule(getApplicationContext()))
                    .networkModule(new NetworkModule(this))
                    .schedulerModule(new SchedulerModule())
                    .build();
        }
        return mAppComponent;
    }
}
