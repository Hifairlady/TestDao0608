package com.edgar.testdao;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    private LiveData<List<User>> mUsers;

    public UserRepository(Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        userDao = userDatabase.userDao();
        mUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getUsers() {
        return mUsers;
    }

    public void insertUsersTest() {
        new insertAsyncTask(userDao).execute(new User(1, "MrA", "LL"),
                new User(2, "MrB", "LL"), new User(3, "MrC", "LL"),
                new User(4, "MrD", "LL"), new User(5, "MrE", "LL"));
    }

    public void insertUsers(User... users) {
        new insertAsyncTask(userDao).execute(users);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mAsyncTaskDao.insertUsers(users);
            return null;
        }
    }

}
