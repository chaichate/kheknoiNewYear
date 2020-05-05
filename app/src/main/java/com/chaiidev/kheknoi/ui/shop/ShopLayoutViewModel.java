package com.chaiidev.kheknoi.ui.shop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShopLayoutViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ShopLayoutViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is ShopLayout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
