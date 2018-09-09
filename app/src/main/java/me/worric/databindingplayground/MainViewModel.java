package me.worric.databindingplayground;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import me.worric.databindingplayground.repository.CoffeeRepositoryImpl;
import me.worric.domain.interactor.fetch.FetchUseCase;
import me.worric.domain.model.Coffee;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<String> mOutputText;
    private final FetchUseCase mFetchUseCase;
    private final MutableLiveData<Coffee> mCoffee;

    public MainViewModel() {
        mOutputText = new MutableLiveData<>();
        mCoffee = new MutableLiveData<>();
        mFetchUseCase = new FetchUseCase(CoffeeRepositoryImpl.getInstance());
    }

    public LiveData<String> getOutputText() {
        return mOutputText;
    }

    public void setOutputText(String outputText) {
        mOutputText.setValue(outputText);
    }

    public LiveData<Coffee> getCoffee() {
        return mCoffee;
    }

    public void fetchCoffee() {
        Coffee coffee = mFetchUseCase.fetchCoffee();
        mCoffee.setValue(coffee);
    }

}
