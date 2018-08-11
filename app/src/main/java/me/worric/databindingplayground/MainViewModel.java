package me.worric.databindingplayground;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<String> mOutputText;

    public MainViewModel() {
        mOutputText = new MutableLiveData<>();
    }

    public LiveData<String> getOutputText() {
        return mOutputText;
    }

    public void setOutputText(String outputText) {
        mOutputText.setValue(outputText);
    }

}
