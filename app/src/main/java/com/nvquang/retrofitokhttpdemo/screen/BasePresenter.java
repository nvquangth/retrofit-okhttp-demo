package com.nvquang.retrofitokhttpdemo.screen;

/**
 * Created by quangnv on 16/08/2018
 */

public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();
}
