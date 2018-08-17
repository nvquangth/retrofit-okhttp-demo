package com.nvquang.retrofitokhttpdemo.util.rx;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by quangnv on 17/08/2018
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
