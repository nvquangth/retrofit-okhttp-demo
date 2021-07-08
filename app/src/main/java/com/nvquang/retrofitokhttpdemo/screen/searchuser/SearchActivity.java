package com.nvquang.retrofitokhttpdemo.screen.searchuser;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nvquang.retrofitokhttpdemo.R;
import com.nvquang.retrofitokhttpdemo.data.datasource.remote.UserRemoteDataSource;
import com.nvquang.retrofitokhttpdemo.data.repository.UserRepository;
import com.nvquang.retrofitokhttpdemo.databinding.ActivitySearchUserBinding;
import com.nvquang.retrofitokhttpdemo.util.rx.SchedulerProvider;

public class SearchActivity extends AppCompatActivity {

    private SearchViewModel mSearchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserRepository userRepository =
                UserRepository.getInstance(UserRemoteDataSource.getInstance(this));
        mSearchViewModel = new SearchViewModel(userRepository);
        mSearchViewModel.setSchedulerProvider(SchedulerProvider.getInstance());

        ActivitySearchUserBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_search_user);
        binding.setViewModel(mSearchViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSearchViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mSearchViewModel.onStop();
        super.onStop();
    }
}
