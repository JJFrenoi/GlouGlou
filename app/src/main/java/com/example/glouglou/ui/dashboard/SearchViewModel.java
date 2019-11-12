package com.example.glouglou.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Search by Cocktail's Name, Ingredients or the first letter");
    }

    public LiveData<String> getText() {
        return mText;
    }
}