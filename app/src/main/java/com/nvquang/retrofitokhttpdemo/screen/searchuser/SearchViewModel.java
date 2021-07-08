package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.nvquang.retrofitokhttpdemo.data.model.SearchResult;
import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;
import com.nvquang.retrofitokhttpdemo.screen.BaseViewModel;
import com.nvquang.retrofitokhttpdemo.util.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by quangnv on 21/08/2018
 */

public class SearchViewModel extends BaseViewModel {
    private static final String TAG = "SearchViewModel";
    private String q;
    private UserAdapter mAdapter;
    private UserRepository mUserRepository;
    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public ObservableList<User> mUsers = new ObservableArrayList<>();
    public ObservableBoolean mIsDataLoading = new ObservableBoolean(false);
    public ObservableBoolean mIsDataNotAvailable = new ObservableBoolean(false);

    public TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence != null && charSequence.length() > 0) {
                // TODO: 8/21/18 search user
                Log.d(TAG, charSequence.toString());
                q = charSequence.toString();
                callAPISearchUsers(charSequence.toString());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public SearchViewModel(UserRepository userRepository) {
        mUserRepository = userRepository;
        mAdapter = new UserAdapter();
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
    }

    public void setSchedulerProvider(SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    public void reSearchUsers(View view) {
        callAPISearchUsers(q);
    }

    public UserAdapter getAdapter() {
        return mAdapter;
    }

    private void callAPISearchUsers(String q) {
        Disposable disposable = mUserRepository.searchUser(q)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mIsDataLoading.set(true);
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        mIsDataLoading.set(false);
                    }
                })
                .subscribe(new Consumer<SearchResult>() {
                    @Override
                    public void accept(SearchResult searchResult) throws Exception {
                        Log.d(TAG, new Gson().toJson(searchResult));
                        mIsDataNotAvailable.set(false);
                        mAdapter.setUsers(searchResult.getUsers());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsDataNotAvailable.set(true);
                        Log.d(TAG, throwable.toString());
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
