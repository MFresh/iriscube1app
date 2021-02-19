package com.example.iriscube1app.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iriscube1app.R
import com.example.iriscube1app.people_list.PeopleListFragment
import kotlinx.android.synthetic.main.fragment_homepage.*


class HomepageFragment : Fragment() {

    // GLOBAL VARIABLES
    private var listener: HomepageFragmentListener? = null

    // INTERFACES
    interface HomepageFragmentListener{
        fun onEnterButtonClicked()
    }

    // OVERRIDE METHODS
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // check if the interface has been implemented
        if(context is HomepageFragmentListener)
            listener = context
        else
            throw Exception(PeopleListFragment.exceptionNoListenerInterface)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_list_button.setOnClickListener {

            listener?.onEnterButtonClicked()

        }

    }




}