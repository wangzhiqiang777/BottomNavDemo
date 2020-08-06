package com.neusoft.qiangzi.bottomnavdemo.ui.me;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neusoft.qiangzi.bottomnavdemo.R;
import com.neusoft.qiangzi.bottomnavdemo.ui.home.HomeViewModel;
import com.neusoft.qiangzi.bottomnavdemo.ui.notifications.NotificationsViewModel;

public class MeFragment extends Fragment {

    private MeViewModel mViewModel;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    MeViewModel viewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel =new ViewModelProvider(this).get(MeViewModel.class);
//                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.me_fragment, container, false);
        final TextView textView = root.findViewById(R.id.textMe);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MeViewModel.class);
//                ViewModelProviders.of(this).get(MeViewModel.class);
        // TODO: Use the ViewModel
    }

}