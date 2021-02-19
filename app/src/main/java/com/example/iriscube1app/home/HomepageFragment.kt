package com.example.iriscube1app.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.iriscube1app.R
import com.example.iriscube1app.people_list.PeopleListFragment
import kotlinx.android.synthetic.main.fragment_homepage.*


class HomepageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_list_button.setOnClickListener {

            requireActivity().supportFragmentManager.commit{

                setReorderingAllowed(true)
                setCustomAnimations(
                    R.anim.slide_from_right,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_from_left
                )

                addToBackStack(null)

                replace(R.id.fragment_container_view, PeopleListFragment())

            }

        }



    }




}