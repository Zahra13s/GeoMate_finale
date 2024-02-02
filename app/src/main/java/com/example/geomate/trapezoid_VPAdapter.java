package com.example.geomate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class trapezoid_VPAdapter extends FragmentStateAdapter {
    public trapezoid_VPAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new trapezoid_area();
        }
        return new trapezoid_perimeter();
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}