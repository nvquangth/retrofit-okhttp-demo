package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.nvquang.retrofitokhttpdemo.R;
import com.nvquang.retrofitokhttpdemo.data.datasource.remote.UserRemoteDataSource;
import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;
import com.nvquang.retrofitokhttpdemo.util.rx.SchedulerProvider;

import java.util.List;

public class UsersActivity extends AppCompatActivity implements UsersContract.View, TextWatcher,
        View.OnClickListener {

    private EditText mEditTextSearch;
    private RecyclerView mRecyclerView;
    private View mLoadingIndicator;
    private View mViewNoUser;

    private UserAdapter mUserAdapter;
    private UserRepository mUserRepository;
    private UsersContract.Presenter mPresenter;
    private String q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        mViewNoUser = findViewById(R.id.linear_data_no_available);
        mLoadingIndicator = findViewById(R.id.linear_loading_indicator);
        mEditTextSearch = findViewById(R.id.text_search);
        mRecyclerView = findViewById(R.id.recycler_view);
        mEditTextSearch.addTextChangedListener(this);
        mViewNoUser.setOnClickListener(this);

        mUserRepository = UserRepository.getInstance(UserRemoteDataSource.getInstance(this));
        mPresenter = new UsersPresenter(mUserRepository, SchedulerProvider.getInstance());
        mPresenter.setView(this);
        mPresenter.onStart();

        mUserAdapter = new UserAdapter(this);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUsers(List<User> users) {
        mUserAdapter.setUsers(users);
    }

    @Override
    public void showFrameNoUser() {
        mViewNoUser.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFrameNoUser() {
        mViewNoUser.setVisibility(View.GONE);
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence != null && charSequence.length() > 0) {
            mPresenter.searchUsers(charSequence.toString());
            q = charSequence.toString();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_data_no_available:
                mPresenter.searchUsers(q);
                break;
        }
    }
}
