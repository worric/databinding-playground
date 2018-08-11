package me.worric.databindingplayground;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import me.worric.databindingplayground.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void handleProcessText(View view) {
        String textFromEditText = mBinding.etInputText.getText().toString();

        if (!TextUtils.isEmpty(textFromEditText)) {
            mBinding.tvOutputText.setText(textFromEditText);
        }
    }

}
