package com.example.iriscube1app.people_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iriscube1app.R
import com.example.iriscube1app.interfaces.MainContract
import com.example.iriscube1app.presenters.PeoplePresenter
import com.example.iriscube1app.repositories.PeopleRepoDependencyInjector
import com.example.iriscube1app.repositories.PeopleRepository
import com.example.iriscube1app.viewmodels.PeopleViewModel
import kotlinx.coroutines.*

class PeopleListFragment : Fragment(), PeopleAdapter.PeopleAdapterListener, MainContract.View {


    // VARIABLES
    private lateinit var recyclerView: RecyclerView
    private var listener: PeopleListFragmentListener? = null
    private lateinit var presenter: MainContract.Presenter
    private var peopleList : List<PersonClass> = listOf()
    var myPeopleAdapter = PeopleAdapter(this, peopleList)


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

        val repository = PeopleRepository()
        setPresenter(PeoplePresenter(this, repository))

        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set up RecyclerView for PeopleList
        recyclerView = view.findViewById(R.id.people_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.setHasFixedSize(true)

        presenter.loadPeopleList()

        recyclerView.adapter = myPeopleAdapter

    }

    // OVERRIDE INTERFACE PEOPLE_ADAPTER_LISTENER METHOD

    override fun onPersonDetailClickedAdapter(myPerson: PersonClass) {
        listener?.onPersonDetailClickedFragment(myPerson)
    }

    // OVERRIDE INTERFACE MAIN_CONTRACT_VIEW AND BASE_VIEW METHOD

    override fun setPresenter(myPresenter: MainContract.Presenter) {
        this.presenter = myPresenter
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override suspend fun onPeopleListLoaded(myPeopleList: List<PersonClass>) {
        peopleList = myPeopleList
        withContext(Dispatchers.Main){
            myPeopleAdapter.updateList(peopleList)
            myPeopleAdapter.notifyDataSetChanged()
        }
    }




}