package com.frinight.gopaper.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomWarnings
import com.frinight.gopaper.data.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE uid = :userId")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    suspend fun getUserById(userId: Long): User?

    @Query("SELECT * FROM users WHERE email = :email")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    suspend fun getUserByEmail(email: String): User?

    @Query("DELETE FROM users WHERE uid = :userId")
    suspend fun deleteUserById(userId: Long)

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    // Metode untuk pembaruan data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: User)

    @Query("SELECT fullName FROM users WHERE uid = :userId")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    suspend fun getFullName(userId: Long): String?

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun loginUser(email: String, password: String): User?

}
