package com.example.hotrovn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.hotrovn.PresenterProcess.InterfacePre;
import com.example.hotrovn.PresenterProcess.Presenter;
import com.example.hotrovn.R;
import com.example.hotrovn.Utilities.Utilities;
import com.example.hotrovn.databinding.ActivityPhoneBinding;

public class PhoneActivity extends AppCompatActivity implements InterfacePre {
    ActivityPhoneBinding binding;
    Presenter presenter;
    Utilities utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Presenter(getBaseContext(), this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_phone);
        utilities.CustomStatusBar(this);
        utilities.onBackPress(binding.imgBackMain, this);
        SpinnerResult();


    }

    private void SpinnerResult() {
        String arr[] = {"Viet Nam", "Hoa Kỳ", "Tung Của"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        binding.spinner.setAdapter(arrayAdapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.edtPhone.setText("" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void Result(Integer integer) {

    }
}