package com.nvquang.retrofitokhttpdemo;

import android.content.Context;

import com.nvquang.retrofitokhttpdemo.util.dagger.AppScope;
import com.nvquang.retrofitokhttpdemo.util.dagger.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quangnv on 26/09/2018
 */

@Module
public class ApplicationModule {
    private Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @ApplicationContext
    @AppScope
    @Provides
    public Context provideApplicationContext() {
        return mContext;
    }
}
