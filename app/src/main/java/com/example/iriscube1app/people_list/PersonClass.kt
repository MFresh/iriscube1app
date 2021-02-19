package com.example.iriscube1app.people_list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.util.*

@Parcelize
data class PersonClass(
    val name: String,
    val surname: String,
    val age: Int,
    val dateOfBirth: LocalDate,
    val presence: Int) : Parcelable