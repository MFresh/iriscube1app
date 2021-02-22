package com.example.iriscube1app.presenters

import com.example.iriscube1app.interfaces.MainContract
import com.example.iriscube1app.interfaces.PeopleRepositoryInterface
import com.example.iriscube1app.people_list.PersonClass
import com.example.iriscube1app.repositories.PeopleRepoDependencyInjector
import com.example.iriscube1app.repositories.PeopleRepository
import kotlinx.coroutines.*

class PeoplePresenter (myView: MainContract.View, myRepository: PeopleRepositoryInterface) : MainContract.Presenter {

    private var repository = myRepository
    private var view: MainContract.View? = myView

    override fun onDestroy() {
        this.view = null
    }

    override fun loadPeopleList(){

        GlobalScope.launch(Dispatchers.IO) {
            val peopleList = repository.loadPeopleList()
            delay(2000)
            view?.onPeopleListLoaded(peopleList)
        }

    }



}