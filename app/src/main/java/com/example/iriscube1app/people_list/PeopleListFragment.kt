package com.example.iriscube1app.people_list

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iriscube1app.MainActivity
import com.example.iriscube1app.R
import com.example.iriscube1app.viewmodels.PeopleViewModel


private lateinit var recyclerView: RecyclerView

class PeopleListFragment : Fragment(), PeopleAdapter.PeopleAdapterListener {

    private var listener: PeopleFragmentListener? = null
    private val myPeopleVM : PeopleViewModel by activityViewModels()

    interface PeopleFragmentListener{
        fun onPersonDetailClickedFragment(myPerson: PersonClass)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is PeopleFragmentListener)
            listener = context
        else
            throw Exception("Must implement Listener!")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.people_recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = PeopleAdapter(this, myPeopleVM)

    }

    override fun onPersonDetailClickedAdapter(myPerson: PersonClass) {
        listener?.onPersonDetailClickedFragment(myPerson)
    }

}