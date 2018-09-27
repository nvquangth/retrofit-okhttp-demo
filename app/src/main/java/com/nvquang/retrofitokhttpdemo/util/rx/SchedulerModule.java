package com.nvquang.retrofitokhttpdemo.util.rx;

import com.nvquang.retrofitokhttpdemo.util.dagger.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quangnv on 27/09/2018
 */

@Module
public class SchedulerModule {
    @Provides
    @AppScope
    public BaseSchedulerProvider provideBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
