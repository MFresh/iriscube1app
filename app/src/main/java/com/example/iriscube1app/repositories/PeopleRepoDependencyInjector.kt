package com.example.iriscube1app.repositories

import com.example.iriscube1app.interfaces.PeopleRepoDependencyInjectorInterface
import com.example.iriscube1app.interfaces.PeopleRepositoryInterface

class PeopleRepoDependencyInjector : PeopleRepoDependencyInjectorInterface {
    override fun peopleRepository(): PeopleRepositoryInterface {
        return PeopleRepository()
    }
}