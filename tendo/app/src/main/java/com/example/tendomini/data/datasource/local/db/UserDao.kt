package com.example.tendomini.data.datasource.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tendomini.data.datasource.local.entites.CURRENT_USER_ID
import com.example.tendomini.data.datasource.local.entites.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: UserEntity)

    @Query("DELETE FROM users WHERE id = $CURRENT_USER_ID")
    fun delete()

    @Query("SELECT * FROM users WHERE id = $CURRENT_USER_ID ")
    fun getUser(): LiveData<UserEntity>
}