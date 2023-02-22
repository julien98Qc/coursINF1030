package com.example.coursinf1030.app

import android.util.Log
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.example.coursinf1030.roomdb.RoomDbExample

// La classe ExampleApplication étend MultiDexApplication et sert à initialiser la base de données
class ExampleApplication : MultiDexApplication() {

    // On déclare une variable lateinit qui représente notre base de données
    lateinit var appDb: RoomDbExample

    // La méthode onCreate est appelée au lancement de l'application
    override fun onCreate() {
        super.onCreate()
        Log.i("MultiDexApplication", "Démarrage réussi")
        /*
        On utilise Room pour créer notre base de données en utilisant le builder pattern
        On précise le contexte (this), la classe RoomDbExample qui représente notre base de données,
        et le nom de la base de données ("database")
        On ajoute également la méthode build() pour construire notre base de données
        */
        appDb = Room.databaseBuilder(this, RoomDbExample::class.java, "database").build()
    }

    fun getDb(): RoomDbExample {
        return appDb
    }
}