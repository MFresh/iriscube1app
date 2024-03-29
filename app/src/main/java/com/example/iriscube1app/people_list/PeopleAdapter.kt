package com.example.iriscube1app.people_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iriscube1app.R
import com.example.iriscube1app.interfaces.MainContract
import com.example.iriscube1app.presenters.PeoplePresenter
import com.example.iriscube1app.viewmodels.PeopleViewModel

class PeopleAdapter(myContext: PeopleListFragment, myPeopleList: List<PersonClass>) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    // GLOBAL VARIABLES
    var context = myContext
    var peopleList = myPeopleList

    // INTERFACE
    interface PeopleAdapterListener {
        fun onPersonDetailClickedAdapter(myPerson: PersonClass)
    }


    // VIEW HOLDER CLASS
    class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val surnameTextView: TextView
        val ageTextView: TextView
        val seeDetailButton: Button
        val logoImageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            nameTextView = view.findViewById(R.id.person_item_name)
            surnameTextView = view.findViewById(R.id.person_item_surname)
            ageTextView = view.findViewById(R.id.person_item_age)
            seeDetailButton = view.findViewById(R.id.see_details_button)
            logoImageView = view.findViewById(R.id.club_logo_imageview)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PeopleViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.people_item, viewGroup, false)

        return PeopleViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: PeopleViewHolder, position: Int) {

            viewHolder.nameTextView.text = peopleList[position].name
            viewHolder.surnameTextView.text = peopleList[position].surname
            viewHolder.ageTextView.text = peopleList[position].age.toString()

            viewHolder.seeDetailButton.setOnClickListener {
                context.onPersonDetailClickedAdapter(peopleList[position])
            }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = peopleList.size


    fun updateList(newList: List<PersonClass>){
        this.peopleList = newList
    }


}