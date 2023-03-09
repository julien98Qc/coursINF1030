package com.example.coursinf1030.roomdb.viewmodel

import android.app.Application
import androidx.core.util.Consumer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coursinf1030.roomdb.model.User
import com.example.coursinf1030.roomdb.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    // Instance de notre repository pour interagir avec la base de données Room
    private val userRepository: UserRepository

    // LiveData contenant la liste des utilisateurs
    var allUsers: LiveData<List<User>>
    val currentLiveUser: MutableLiveData<User> = MutableLiveData<User>()

    init {
        userRepository = UserRepository(application)
        allUsers = userRepository.getAllUsers()
    }

    fun getAsyncAll(callback: Consumer<LiveData<List<User>>>) {
        userRepository.getAsyncAll(callback)
    }

    fun liveAll(): LiveData<List<User>> {
        return allUsers
    }

    suspend fun save(user: User) {
        userRepository.insertUser(user)
    }

    fun setCurrentUser(currentUser:User){
        currentLiveUser.postValue(currentUser)
    }

    fun getCurrentUser(): MutableLiveData<User> {
        return currentLiveUser
    }

}
