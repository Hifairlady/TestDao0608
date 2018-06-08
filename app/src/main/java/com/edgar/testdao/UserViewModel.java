package com.edgar.testdao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;

    private MutableLiveData<List<User>> mUsers;

    public UserViewModel(Context context) {
//        userRepository = new UserRepository(context);
//        mUsers = userRepository.getUsers();
        mUsers = new MutableLiveData<>();
    }

    LiveData<List<User>> getUsers() {
        return userRepository.getUsers();
    }

    public void setmUsers(List<User> mUsers) {
        this.mUsers.postValue(mUsers);
    }

    public void insertUsers(User... users) {
        userRepository.insertUsers(users);
    }

    public void insertUsersTest() {
        userRepository.insertUsersTest();
    }

}
