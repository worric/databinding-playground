package me.worric.databindingplayground;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.worric.databindingplayground.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

}
