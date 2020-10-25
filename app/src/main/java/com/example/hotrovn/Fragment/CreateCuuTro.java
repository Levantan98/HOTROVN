package com.example.hotrovn.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.hotrovn.R;
import com.example.hotrovn.databinding.CreateCuutroFragmentBinding;

public class CreateCuuTro extends Fragment {
    CreateCuutroFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.create_cuutro_fragment, container, false);
        return binding.getRoot();
    }
}
