package com.example.coursinf1030.labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.coursinf1030.R

class Labo2Sceance2Part2 : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var finishButton: Button
    private lateinit var fragment1Button: Button
    private lateinit var fragment2Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labo2_sceance2_part2)

        val stringExtra = intent.getStringExtra("STRING_VALUE")
        Log.d("Labo2Sceance2Part2", stringExtra.toString())

        //Bouton qui sert à me déplacer vers une autre activité
        button = findViewById(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, Labo2Sceance2::class.java)
            startActivity(intent)
        }
        //Bouton qui sert à appeler finish()
        finishButton = findViewById(R.id.button3)
        finishButton.setOnClickListener {
            finish()
        }


        val blankFragment1 = BlankFragment1()
        val blankFragment2 = BlankFragment2()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment1, blankFragment1)
            commit()
        }
        //Bouton qui sert à switch de fragment
        fragment1Button = findViewById(R.id.button4)
        fragment1Button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment1, blankFragment1)
                commit()
            }
        }
        //Bouton qui sert à switch de fragment
        fragment2Button = findViewById(R.id.button5)
        fragment2Button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment1, blankFragment2)
                commit()
            }
        }
    }

}