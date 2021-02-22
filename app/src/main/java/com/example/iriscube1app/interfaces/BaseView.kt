package com.example.iriscube1app.interfaces

interface BaseView<T> {
    fun setPresenter(myPresenter: MainContract.Presenter)
}