package com.example.hotrovn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.hotrovn.PresenterProcess.InterfacePre;
import com.example.hotrovn.PresenterProcess.Presenter;
import com.example.hotrovn.R;
import com.example.hotrovn.Utilities.Utilities;
import com.example.hotrovn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements InterfacePre {
    ActivityMainBinding binding;

    Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        super.onCreate(savedInstanceState);
        presenter = new Presenter(getBaseContext(), this);
       Utilities.CustomStatusBar(this);
        optionCLick(binding.btnCuutro, 0);
        optionCLick(binding.btnMtq, 1);
    }

    private void optionCLick(View view, final Integer integer) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.optionUser(MainActivity.this, integer);
            }
        });
    }

    @Override
    public void Result(Integer integer) {

    }
}