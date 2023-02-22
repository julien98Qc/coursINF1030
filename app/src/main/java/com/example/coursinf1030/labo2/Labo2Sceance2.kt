package com.example.coursinf1030.labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import com.example.coursinf1030.R
import com.example.coursinf1030.RecyclerViewExample

class Labo2Sceance2 : AppCompatActivity() {
    //Variable statique de la classe, en kotlin, on utilise les companion object pour ce qui est statique
    companion object {
        const val TAG = "Labo2Sceance2"
        //Clés pour la méthode onSaveInstanceState
        const val STATE_VARIABLE1 = "variable1"     //La chaîne de caractères doit correspondre au nom des variables qu'on souhaite récupérées.
        const val STATE_VARIABLE2 = "variable2"
    }

    //Les variables d'états qu'on souhaite récupérées
    private var variable1: String = "Valeur 1"
    private var variable2: Int = 42
    private lateinit var button: Button
    private lateinit var pictureButton: Button
    private lateinit var recyclerViewExampleButton: Button

    //On ajoute des logs pour voir les différents changements d'états de l'activité
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labo2_sceance2)
        Log.d(TAG, "onCreate")      //Messages de log ajoute a chacune des methodes de rappel (callback)
        //Bouton qui sert à me déplacer vers une autre activité
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Labo2Sceance2Part2::class.java)
            intent.putExtra("STRING_VALUE", "chaine de caractère envoyé à la deuxieme activite")
            startActivity(intent);
        }
        //Bouton qui sert à ouvrir l'appareil photo
        pictureButton = findViewById(R.id.button2)
        pictureButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
            //startActivityForResult si on souhaite récupéré l'image
        }
        //Bouton qui sert à ouvrir l'activité avec le recyclerview
        recyclerViewExampleButton = findViewById(R.id.button6)
        recyclerViewExampleButton.setOnClickListener {
            val intent = Intent(this, RecyclerViewExample::class.java)
            startActivity(intent);
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    //Ajoute des logs aux methodes onSaveInstanceState() et onRestorestate()
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(STATE_VARIABLE1, variable1)
        outState.putInt(STATE_VARIABLE2, variable2)
        Log.i(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }
    //La restauration peut se faire dans la méthode onCreate en vérifiant si savedInstanceState est null
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Récupération des variables d'état sauvegardées dans le Bundle
        variable1 = savedInstanceState.getString("STATE_VARIABLE1").toString()
        variable2 = savedInstanceState.getInt("STATE_VARIABLE2")
        Log.i(TAG, "onRestoreInstanceState")
    }
}