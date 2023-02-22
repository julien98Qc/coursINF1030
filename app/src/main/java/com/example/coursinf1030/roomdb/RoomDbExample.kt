package com.example.coursinf1030.roomdb
//https://developer.android.com/training/data-storage/room/accessing-data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursinf1030.roomdb.dao.UserDao
import com.example.coursinf1030.roomdb.model.User

//Pour utiliser room tu dois l'ajouter dans les dependances graddle

//Maintenant on crée une classe abstraite qui étend la classe RoomDatabase
@Database(entities = [User::class], version = 1)
abstract class RoomDbExample : RoomDatabase() {
    abstract fun userDao(): UserDao
}