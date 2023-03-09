package com.example.coursinf1030

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursinf1030.app.ExampleApplication
import com.example.coursinf1030.roomdb.dao.UserDao
import com.example.coursinf1030.roomdb.model.User
import com.example.coursinf1030.roomdb.model.UserAdapter
import com.example.coursinf1030.roomdb.viewmodel.UserViewModel

class RecyclerViewExample : AppCompatActivity() {
    private lateinit var myRecView: RecyclerView
    private lateinit var viewModel: UserViewModel
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)
        adapter = UserAdapter(this)

        //On récupère notre RecyclerView
        myRecView = findViewById(R.id.myRecView)
        //On lui assigne un LayoutManager
        myRecView.layoutManager = LinearLayoutManager(this)
        //On lui fournit notre Adapter avec notre collection de données
        myRecView.adapter = adapter

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.liveAll().observe(this){
            users -> adapter.setData(users)
        }
    }

}