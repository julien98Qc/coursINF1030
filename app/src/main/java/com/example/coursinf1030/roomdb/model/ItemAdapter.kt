package com.example.coursinf1030.roomdb.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coursinf1030.R

class ItemAdapter(private val dataSet: List<User>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val prenom: TextView
        val nom: TextView

        init {
            // Define click listener for the ViewHolder's View
            prenom = view.findViewById(R.id.textView)
            nom = view.findViewById(R.id.textView2)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Remplace le contenu du prototype
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        /*
        Prend l'élément de notre collection de données à la position mentionnée
        et remplace le contenu de notre prototype avec cet élément
        */
        viewHolder.nom.text = dataSet[position].lastName
        viewHolder.prenom.text = dataSet[position].firstName
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}