package com.frinight.gopaper.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Long = 0,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "fullName") var fullName: String?,
    @ColumnInfo(name = "phoneNumber") var phoneNumber: String?,
    @ColumnInfo(name = "address") var address: String?,
    @ColumnInfo(name = "password") var password: String
)
