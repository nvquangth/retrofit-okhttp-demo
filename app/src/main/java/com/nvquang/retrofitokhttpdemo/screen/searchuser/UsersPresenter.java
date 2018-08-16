package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import com.nvquang.retrofitokhttpdemo.data.datasource.UserDataSource;
import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;

import java.util.List;

/**
 * Created by quangnv on 16/08/2018
 */

public class UsersPresenter implements UsersContract.Presenter {

    private UserRepository mUserRepository;
    private UsersContract.View mView;

    public UsersPresenter(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public void searchUsers(String q) {
        mUserRepository.searchUser(q, new UserDataSource.Callback<List<User>>() {
            @Override
            public void onStartLoading() {

            }

            @Override
            public void onLoaded(List<User> data) {
                mView.showUsers(data);
            }

            @Override
            public void onDataNotAvailable(Exception e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void setView(UsersContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
