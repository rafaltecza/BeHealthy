package com.example.behealthy.ui.recipes.child;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private int type;

    public MyViewModelFactory(int type) {
        this.type = type;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new ChildViewModel(this.type);
    }
}

