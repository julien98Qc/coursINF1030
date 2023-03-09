package com.example.coursinf1030.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.coursinf1030.roomdb.model.User

/*
Dans cet exemple, le DAO contient des méthodes pour effectuer des opérations CRUD sur la table "user" de la base de données.
Les annotations @Query, @Insert et @Delete sont utilisées pour indiquer à Room quelles requêtes SQL doivent être générées pour ces méthodes.
*/

@Dao
interface UserDao {
    //Retourne tous les User
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    //Retourne une liste d'User qui correspond à la liste d'id
    @Query("SELECT * FROM user WHERE uid IN (:userIds)") //Le ":" est important, le paramètre donné à cette fonction remplacera ":userIds"
    fun loadAllByIds(userIds: IntArray): LiveData<List<User>>

    //Retourne l'User dont le nom et prénom correspond
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): LiveData<User>

    //Insère un nombre variable d'User
    @Insert
    fun insertAll(vararg users: User)   //vararg permet d'accepter un nombre variable d'argument

    //Insère un User
    @Insert
    fun insert(user: User)

    //Supprime un utilisateur
    @Delete
    fun delete(user: User)
}
