package me.worric.databindingplayground;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.worric.databindingplayground.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;
    private MainViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mBinding.setViewmodel(mViewModel);
        mBinding.setClickListener(mListener);
        mBinding.setLifecycleOwner(this);
    }

    private ClickListener mListener = new ClickListener() {
        @Override
        public void onProcessTextClicked(View view) {
            String textToProcess = mBinding.etInputText.getText().toString();

            if (!TextUtils.isEmpty(textToProcess)) {
                mViewModel.setOutputText(textToProcess);
            }
        }

        @Override
        public void onNotificationButtonClicked(View view) {
            Toast.makeText(getContext(), R.string.toast_main_message, Toast.LENGTH_SHORT).show();
        }
    };

    public interface ClickListener {
        void onProcessTextClicked(View view);
        void onNotificationButtonClicked(View view);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {
    }

}
