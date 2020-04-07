package com.ppal007.recyclerview_with_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ppal007.recyclerview_with_mvvm.model.User;
import com.ppal007.recyclerview_with_mvvm.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User[]> getAllUserData(){
        return userRepository.getUserData();
    }
}
