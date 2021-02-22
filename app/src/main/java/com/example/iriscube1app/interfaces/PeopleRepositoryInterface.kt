package com.example.iriscube1app.interfaces

import com.example.iriscube1app.people_list.PersonClass

interface PeopleRepositoryInterface {
        fun loadPerson(position: Int): PersonClass
        fun loadPeopleList(): List<PersonClass>
}