package com.mx3.somethingtodo.ui.main;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.mx3.somethingtodo.R;
import com.mx3.somethingtodo.databinding.ActivityMainBinding;
import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;

    private SensorManager mSensorManager;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupViewModel();

        setupButtonListeners();

        setupSensor();
        setupShakeDetector();

        // fetch a random activity for the first time
        mViewModel.retrieveRandomActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShakeDetector.start(mSensorManager);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mShakeDetector.stop();
    }

    private void setupViewModel() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getActivityLiveData().observe(this, activity -> mBinding.setActivity(activity));
    }

    private void setupButtonListeners() {
        mBinding.generateActivityButton.setOnClickListener(view -> mViewModel.retrieveRandomActivity());
    }

    private void setupSensor() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    private void setupShakeDetector() {
        mShakeDetector = new ShakeDetector(this);
        mShakeDetector.setSensitivity(ShakeDetector.SENSITIVITY_LIGHT);
        mShakeDetector.start(mSensorManager);
    }

    @Override
    public void hearShake() {
        mViewModel.retrieveRandomActivity();
        Log.d(LOG_TAG, "Sensor Vibration");
    }
}