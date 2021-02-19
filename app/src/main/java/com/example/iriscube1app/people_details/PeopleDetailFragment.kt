package com.example.iriscube1app.people_details

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.iriscube1app.R
import com.example.iriscube1app.people_list.PeopleListFragment
import com.example.iriscube1app.people_list.PersonClass
import com.example.iriscube1app.viewmodels.PeopleViewModel
import kotlinx.android.synthetic.main.fragment_people_detail.*

class PeopleDetailFragment : Fragment() {

    private var person : PersonClass? = null

    companion object {
        const val personIndexForBundle : String = "PERSON"
        const val exceptionNoPersonArgument : String = "Error: no values present"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people_detail, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(requireArguments().getParcelable<PersonClass>(personIndexForBundle) != null)
            person = requireArguments().getParcelable(personIndexForBundle)
        else
            throw Exception(exceptionNoPersonArgument)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detail_surname.text = person?.surname
        detail_name.text = person?.name
        detail_age.text = person?.age.toString()
        detail_dateofbirth.text = person?.dateOfBirth.toString()
        detail_presence.text = person?.presence.toString()

        back_to_list_button.setOnClickListener{

            requireActivity().supportFragmentManager.popBackStack()

        }



    }

}