package com.nvquang.retrofitokhttpdemo.screen;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by quangnv on 27/09/2018
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initView();
        registerListener();
        initComponent(savedInstanceState);
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void initView();

    protected abstract void registerListener();

    protected abstract void initComponent(@Nullable Bundle savedInstanceState);
}
