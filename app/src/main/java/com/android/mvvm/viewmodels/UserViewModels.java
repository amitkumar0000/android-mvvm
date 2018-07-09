package com.android.mvvm.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.mvvm.models.UserModels;


public class UserViewModels extends ViewModel {

    UserModels userModels;
    MutableLiveData<String> userModelsLiveData;

    public UserViewModels() {
        userModels = new UserModels();
        userModelsLiveData = new MutableLiveData<>();
    }

    public void onclick(String firstName,String lastName) {
        //Viewmodel update model
        userModels.setFirstName(firstName);
        userModels.setLastName(lastName);

        //viewmodel expose stream of data
        userModelsLiveData.postValue(userModels.getFirstName()+userModels.getLastName());
    }

    public LiveData<String> getUserModels(){
        return userModelsLiveData;
    }



}
