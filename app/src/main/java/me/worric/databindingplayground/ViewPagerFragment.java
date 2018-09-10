package me.worric.databindingplayground;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.worric.databindingplayground.databinding.FragmentViewpagerBinding;

public class ViewPagerFragment extends Fragment {

    private FragmentViewpagerBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_viewpager, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FragmentPagerAdapter fpa = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return MainFragment.newInstance();
                    case 1:
                        return SecondFragment.newInstance();
                    default:
                        throw new IllegalArgumentException("Unknown position in FragmentPagerAdapter: " + position);
                }
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "First";
                    case 1:
                        return "Second";
                    default:
                        throw new IllegalArgumentException("Unknown position in FragmentPagerAdapter: " + position);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
        mBinding.viewPager.setAdapter(fpa);
    }

    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    public ViewPagerFragment() {
    }

}
