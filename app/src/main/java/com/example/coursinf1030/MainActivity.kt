package com.example.coursinf1030

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/*
C'est quoi une activité?
Une activité est la composante principale d’une application Android.
C’est le contrôleur d’une vue dans une application Android.
*/

/*
Cycle de vie d'une activité
Créée (created) : l'activité est créée mais n'a pas encore été lancée ou affichée.
Démarrée (started) : l'activité est lancée et affichée à l'écran, mais elle n'a pas encore le focus de l'utilisateur.
Reprenant (resumed) : l'activité est visible à l'utilisateur et a le focus. C'est l'état où l'utilisateur interagit le plus avec l'activité.
Mettant en pause (paused) : l'activité est partiellement visible à l'utilisateur mais elle n'a plus le focus.
                        Elle peut être mise en pause par une autre activité ou par une autre fonctionnalité de l'appareil, comme un appel téléphonique.
Arrêtée (stopped) : l'activité est cachée ou fermée. Elle peut être relancée par l'utilisateur ou par un autre composant de l'application.
*/
class MainActivity : AppCompatActivity() {
    //Exemple de variables membres
    lateinit var textView: TextView

    /*
    les méthodes onCreate(), onStart(), onResume(), onPause(), onStop() et onDestroy() sont des
    méthodes de rappel (callback) qui sont appelées lorsque l'état de l'activité change.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //On associe le layout

        //Initialisation de notre variable membre
        textView = findViewById(R.id.textView1) //On recherche une ressource par son id, notre TextView s'est fait assigne cet id dans notre fichier xml
    }
}

//Implementation d'une activite (Etapes)
//1. Manifester l'activite
//2. Creation du layout xml
//3. Redefinir la methode onCreate et y associer le layout
//4. Ajouter des variables et methodes membres au besoin.
//5. Implementer d'autre methodes abstraites de Activity (AppCompatActivity)