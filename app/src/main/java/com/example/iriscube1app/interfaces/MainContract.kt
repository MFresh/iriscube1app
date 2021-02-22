package com.example.iriscube1app.interfaces

import com.example.iriscube1app.people_list.PersonClass

interface MainContract {

    interface Presenter : BasePresenter {
        fun loadPeopleList()
    }

    interface View : BaseView<Presenter> {
        suspend fun onPeopleListLoaded(myPeopleList: List<PersonClass>)
    }
}