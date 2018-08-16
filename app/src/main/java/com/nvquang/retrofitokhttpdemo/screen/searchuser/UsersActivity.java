package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.nvquang.retrofitokhttpdemo.R;
import com.nvquang.retrofitokhttpdemo.data.datasource.remote.UserRemoteDataSource;
import com.nvquang.retrofitokhttpdemo.data.model.User;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;

import java.util.List;

public class UsersActivity extends AppCompatActivity implements UsersContract.View, TextWatcher {

    private EditText mEditTextSearch;
    private RecyclerView mRecyclerView;

    private UserAdapter mUserAdapter;
    private UserRepository mUserRepository;
    private UsersContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        mEditTextSearch = findViewById(R.id.text_search);
        mRecyclerView = findViewById(R.id.recycler_view);
        mEditTextSearch.addTextChangedListener(this);

        mUserRepository = UserRepository.getInstance(UserRemoteDataSource.getInstance(this));
        mPresenter = new UsersPresenter(mUserRepository);
        mPresenter.setView(this);

        mUserAdapter = new UserAdapter(this);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public void showUsers(List<User> users) {
        mUserAdapter.setUsers(users);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence != null && charSequence.length() > 0) {
            mPresenter.searchUsers(charSequence.toString());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
