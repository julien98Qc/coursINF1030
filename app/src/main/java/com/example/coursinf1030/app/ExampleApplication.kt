package com.example.coursinf1030.app

import android.util.Log
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.example.coursinf1030.roomdb.RoomDbExample
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

// La classe ExampleApplication étend MultiDexApplication et sert à initialiser la base de données
class ExampleApplication : MultiDexApplication() {

    // On déclare une variable lateinit qui représente notre base de données
    lateinit var appDb: RoomDbExample
    //Pool qui va empêcher que trop de thread soit exécuté en même temps
    var dbWPool:ThreadPoolExecutor = Executors.newFixedThreadPool(1) as ThreadPoolExecutor
    var dbRPool:ThreadPoolExecutor = Executors.newFixedThreadPool(4) as ThreadPoolExecutor


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

        appDb = Room.databaseBuilder(this, RoomDbExample::class.java, "database").build() //AllowMainThreadQueries si on veut le faire sur le thread principal
    }

    fun getDb(): RoomDbExample {
        return appDb
    }


    //Si on veut soumettre des threads a notre pool
    fun dbPostWrite(task: Runnable){
        dbWPool.submit(task)
    }
    fun dbPostRead(task: Runnable){
        dbRPool.submit(task)
    }
}