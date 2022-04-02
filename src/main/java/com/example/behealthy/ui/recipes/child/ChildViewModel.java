package com.example.behealthy.ui.recipes.child;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChildViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChildViewModel(int type) {
        mText = new MutableLiveData<>();
        switch(type) {
            case 0:
                mText.setValue("Przepis 1");
                break;
            case 1:
                mText.setValue("Przepis 2");
                break;
        }
    }

    public LiveData<String> getText() {
        return mText;
    }

}