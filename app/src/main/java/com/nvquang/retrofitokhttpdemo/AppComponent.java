package com.nvquang.retrofitokhttpdemo;

import android.content.Context;

import com.nvquang.retrofitokhttpdemo.data.source.remote.service.NetworkModule;
import com.nvquang.retrofitokhttpdemo.data.source.remote.service.StackOverflowAPI;
import com.nvquang.retrofitokhttpdemo.util.dagger.AppScope;
import com.nvquang.retrofitokhttpdemo.util.dagger.ApplicationContext;
import com.nvquang.retrofitokhttpdemo.util.rx.BaseSchedulerProvider;
import com.nvquang.retrofitokhttpdemo.util.rx.SchedulerModule;

import dagger.Component;

/**
 * Created by quangnv on 26/09/2018
 */

@AppScope
@Component(modules = {ApplicationModule.class, NetworkModule.class, SchedulerModule.class})
public interface AppComponent {

    StackOverflowAPI nameApi();

    @ApplicationContext
    Context applicationContext();

    BaseSchedulerProvider baseSchedulerProvider();
}
