package com.example.coursinf1030.roomdb.repository

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.core.util.Consumer
import androidx.lifecycle.LiveData
import com.example.coursinf1030.app.ExampleApplication
import com.example.coursinf1030.roomdb.dao.UserDao
import com.example.coursinf1030.roomdb.model.User


class UserRepository(context: Application) {
    var app = context as ExampleApplication
    var userDao: UserDao = app.getDb().userDao()

    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAll()
    }

    //getAllUserAsync()
    fun getAsyncAll(completion: Consumer<LiveData<List<User>>>) {
        app.dbPostRead() {
            val users: LiveData<List<User>> = userDao.getAll()
            if (completion != null) {
                Handler(Looper.getMainLooper()).post { completion.accept(users) }
            }
        }
    }
    // Retourne une liste d'User qui correspond à la liste d'id
    fun getUsersByIds(userIds: IntArray): LiveData<List<User>> {
        return userDao.loadAllByIds(userIds)
    }

    // Retourne l'User dont le nom et prénom correspond
    fun getUserByName(firstName: String, lastName: String): LiveData<User> {
        return userDao.findByName(firstName, lastName)
    }

    // Insère un nombre variable d'User
    suspend fun insertAllUsers(vararg users: User) {        //Suspend permet d'éviter l'usage d'un pool threadPoolExecutor
        userDao.insertAll(*users)
    }

    // Insère un User
    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    // Supprime un utilisateur
    suspend fun deleteUser(user: User) {
        userDao.delete(user)
    }
}