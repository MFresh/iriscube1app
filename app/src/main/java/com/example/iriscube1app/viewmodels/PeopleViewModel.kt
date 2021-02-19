package com.example.iriscube1app.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.iriscube1app.people_list.PersonClass
import java.time.LocalDate

class PeopleViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val myData = listOf<PersonClass>(
        PersonClass("Alessandro", "Del Piero", 46, LocalDate.of(1974, 11, 9), 705),
        PersonClass("David", "Trezeguet", 43, LocalDate.of(1977, 10, 15), 695),
        PersonClass("Edgar", "Davids", 47, LocalDate.of(1973, 3, 13), 428),
        PersonClass("Gianluigi", "Buffon", 43, LocalDate.of(1978, 1, 28), 708),
        PersonClass("Gianluca", "Zambrotta", 43, LocalDate.of(1977, 2, 19), 477),
    )





}