package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;
import com.nvquang.retrofitokhttpdemo.data.source.remote.UserRemoteDataSource;
import com.nvquang.retrofitokhttpdemo.util.dagger.ActivityScope;
import com.nvquang.retrofitokhttpdemo.util.rx.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by quangnv on 27/09/2018
 */

@Module
class UserModule {

    @ActivityScope
    @Provides
    UserRepository provideUserRepository(UserRemoteDataSource remoteDataSource) {
        return UserRepository.getInstance(remoteDataSource);
    }

    @ActivityScope
    @Provides
    UsersContract.Presenter providerUserPresenter(UserRepository repository, BaseSchedulerProvider provider, CompositeDisposable disposable) {
        return new UsersPresenter(repository, provider, disposable);
    }

    @ActivityScope
    @Provides
    CompositeDisposable providerCompositeDisposable() {
        return new CompositeDisposable();
    }
}
