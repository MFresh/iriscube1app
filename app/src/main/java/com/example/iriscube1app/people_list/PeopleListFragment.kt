package com.example.iriscube1app.people_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iriscube1app.R
import com.example.iriscube1app.viewmodels.PeopleViewModel

class PeopleListFragment : Fragment(), PeopleAdapter.PeopleAdapterListener {


    // GLOBAL VARIABLES
    private lateinit var recyclerView: RecyclerView
    private var listener: PeopleListFragmentListener? = null
    private val myPeopleVM : PeopleViewModel by activityViewModels()


    // COMPANION OBJECT
    companion object{
        const val exceptionNoListenerInterface : String = "Must implement Listener!"
    }

    // INTERFACES
    interface PeopleListFragmentListener{
        fun onPersonDetailClickedFragment(myPerson: PersonClass)
    }


    // OVERRIDE METHODS
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // check if the interface has been implemented
        if(context is PeopleListFragmentListener)
            listener = context
        else
            throw Exception(exceptionNoListenerInterface)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // set up RecyclerView for PeopleList
        recyclerView = view.findViewById(R.id.people_recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = PeopleAdapter(this, myPeopleVM)

    }

    // OVERRIDE INTERFACE PEOPLE_ADAPTER_LISTENER METHOD
    override fun onPersonDetailClickedAdapter(myPerson: PersonClass) {
        listener?.onPersonDetailClickedFragment(myPerson)
    }

}