package com.example.coursinf1030

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Le code permet de stocker un entier dans les préférences partagées (shared preferences) de l'application Android en utilisant l'objet SharedPreferences.
https://developer.android.com/training/data-storage?hl=en
*/

class SharedPreferencesExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_example)

        /*
        Le premier bloc de code permet d'initialiser un objet SharedPreferences en utilisant le nom spécifié
        (ici, "com.example.coursinf1030.sharedpreferencesexample") et le mode privé (MODE_PRIVATE).
        Le mode privé garantit que les préférences ne sont accessibles que par l'application elle-même.
        */
        val pref = getSharedPreferences("com.example.coursinf1030.sharedpreferencesexample", MODE_PRIVATE)

        /*
        On utilise l'objet editor de SharedPreferences pour écrire une valeur entière dans les préférences partagées.
        Dans ce cas, on stocke la valeur 10 sous la clé "myIntValue".
        */
        val editor = pref.edit()
        editor.putInt("myIntValue", 10)
        editor.apply()

        /*
        En Android, les SharedPreferences sont sauvegardées de manière asynchrone. Cela signifie que si vous utilisez la méthode commit(),
        cela peut bloquer le thread principal de l'application pendant un certain temps. En revanche, la méthode apply() applique les modifications
        de manière asynchrone, ce qui signifie qu'elle ne bloque pas le thread principal et que les modifications sont sauvegardées en arrière-plan.

        La méthode apply() est donc préférable pour les opérations qui ne nécessitent pas de retour immédiat. Toutefois, il est important de noter
        que si l'application se ferme brusquement avant que les modifications ne soient appliquées, les modifications pourraient être perdues.
        Dans ce cas, commit() peut être utilisé pour garantir que les modifications sont sauvegardées de manière synchrone avant la fermeture de l'application.


        Maintenant, on lit la valeur stockée dans les préférences partagées sous la clé "myIntValue" en utilisant la méthode getInt. Si aucune valeur n'est trouvée pour la clé, la valeur par défaut de 20 sera retournée.
        */
        var restoredValue = pref.getInt("myIntValue", 20)
    }
}