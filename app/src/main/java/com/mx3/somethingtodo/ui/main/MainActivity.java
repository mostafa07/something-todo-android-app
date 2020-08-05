package com.mx3.somethingtodo.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.mx3.somethingtodo.R;
import com.mx3.somethingtodo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupViewModel();

        setupButtons();
    }

    private void setupViewModel() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getActivityLiveData().observe(this, activity -> {
            mBinding.setActivity(activity);
        });
    }

    private void setupButtons() {
        mBinding.generateActivityButton.setOnClickListener(view -> {
            mViewModel.retrieveRandomActivity();
        });
    }
}