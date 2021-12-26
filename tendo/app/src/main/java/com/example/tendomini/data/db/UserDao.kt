package com.example.tendomini.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tendomini.data.models.CURRENT_USER_ID
import com.example.tendomini.data.models.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User)

    @Query("DELETE FROM users WHERE id = $CURRENT_USER_ID")
    fun delete()

    @Query("SELECT * FROM users WHERE id = $CURRENT_USER_ID ")
    fun getUser(): LiveData<User>
}