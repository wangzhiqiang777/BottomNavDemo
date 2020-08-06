package com.neusoft.qiangzi.bottomnavdemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.neusoft.qiangzi.bottomnavdemo.R;
import com.neusoft.qiangzi.bottomnavdemo.ui.motivation.RotateFragment;
import com.neusoft.qiangzi.bottomnavdemo.ui.motivation.ScaleFragment;
import com.neusoft.qiangzi.bottomnavdemo.ui.motivation.TranslateFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        ViewPager2 viewPager2 = root.findViewById(R.id.viewPager2);
        viewPager2.setAdapter(new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 0: return new ScaleFragment();
                    case 1: return new RotateFragment();
                    case 2: return new TranslateFragment();
                    default: return null;
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });
        TabLayout tabLayout = root.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("缩放");break;
                    case 1:
                        tab.setText("旋转");break;
                    case 2:
                        tab.setText("移动");break;
                }
            }
        }).attach();
        return root;
    }
}