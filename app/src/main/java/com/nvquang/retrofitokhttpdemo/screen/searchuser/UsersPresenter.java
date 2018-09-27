package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;
import com.nvquang.retrofitokhttpdemo.util.rx.BaseSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by quangnv on 16/08/2018
 */

public class UsersPresenter implements UsersContract.Presenter {

    private UserRepository mUserRepository;
    private UsersContract.View mView;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    public UsersPresenter(UserRepository userRepository,
                          BaseSchedulerProvider provider,
                          CompositeDisposable disposable) {
        mUserRepository = userRepository;
        mSchedulerProvider = provider;
        mCompositeDisposable = disposable;
    }

    @Override
    public void searchUsers(String q) {
        Disposable disposable = mUserRepository.searchUser(q)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.hideFrameNoUser();
                        mView.showLoadingIndicator();
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.hideLoadingIndicator();
                    }
                })
                .subscribe(new Consumer<SearchResult>() {
                    @Override
                    public void accept(SearchResult searchResult) throws Exception {
                        mView.showUsers(searchResult.getUsers());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFrameNoUser();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void setView(UsersContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {
        mView.hideFrameNoUser();
        mView.hideLoadingIndicator();
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
