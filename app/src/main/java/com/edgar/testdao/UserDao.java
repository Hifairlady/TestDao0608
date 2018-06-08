package com.edgar.testdao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE id = :userId LIMIT 1")
    LiveData<User> getUserById(int userId);

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last")
    LiveData<User> getUserByName(String first, String last);

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    LiveData<List<User>> getUsersByIds(int[] userIds);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(User... users);

    @Delete
    void deleteUser(User user);

}
