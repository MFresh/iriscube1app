package com.example.iriscube1app.interfaces

import com.example.iriscube1app.repositories.PeopleRepository

interface PeopleRepoDependencyInjectorInterface {

    fun peopleRepository(): PeopleRepositoryInterface

}