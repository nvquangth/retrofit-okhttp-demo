package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import com.nvquang.retrofitokhttpdemo.AppComponent;
import com.nvquang.retrofitokhttpdemo.util.dagger.ActivityScope;

import dagger.Component;

/**
 * Created by quangnv on 27/09/2018
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = UserModule.class)
public interface UserComponent {
    void inject(UsersActivity activity);
}
