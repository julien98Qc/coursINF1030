package com.example.coursinf1030

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursinf1030.app.ExampleApplication
import com.example.coursinf1030.roomdb.model.ItemAdapter
import com.example.coursinf1030.roomdb.model.User

class RecyclerViewExample : AppCompatActivity() {
    private lateinit var myRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)

        //On accède au singleton de la base de donnée
        val application = this.application as ExampleApplication
        val appDb = application.getDb()

        val firstNames = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Harry", "Isabel", "John", "Kate", "Liam", "Mia", "Nora", "Oliver", "Penny", "Quinn", "Ruby", "Sophia", "Tom")
        val lastNames = arrayOf("Adams", "Baker", "Clark", "Davis", "Evans", "Franklin", "Green", "Harris", "Irwin", "Jones", "King", "Lee", "Miller", "Nelson", "Owens", "Patel", "Quinn", "Roberts", "Smith", "Taylor")

        val dao = appDb.userDao()

        for (i in 1..20) {
            val firstName = firstNames.random()
            val lastName = lastNames.random()
            val user = User(i, firstName, lastName)
            dao.insert(user)
        }

        //On récupère notre RecyclerView
        myRecView = findViewById(R.id.myRecView)
        //On lui assigne un LayoutManager
        myRecView.layoutManager = LinearLayoutManager(this)
        //On lui fournit notre Adapter avec notre collection de données
        myRecView.adapter = ItemAdapter(appDb.userDao().getAll())
    }
}