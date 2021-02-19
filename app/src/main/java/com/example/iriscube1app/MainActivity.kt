package com.example.iriscube1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.iriscube1app.home.HomepageFragment
import com.example.iriscube1app.people_details.PeopleDetailFragment
import com.example.iriscube1app.people_list.PeopleListFragment
import com.example.iriscube1app.people_list.PersonClass

class MainActivity : AppCompatActivity(R.layout.activity_main),
                     PeopleListFragment.PeopleListFragmentListener,
                     HomepageFragment.HomepageFragmentListener{



    // OVERRIDE METHODS
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState  == null){
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<HomepageFragment>(R.id.fragment_container_view)
            }

        }

        setContentView(R.layout.activity_main)
    }

    // OVERRIDE INTERFACE PEOPLE_LIST_LISTENER
    override fun onPersonDetailClickedFragment(myPerson: PersonClass) {

        supportFragmentManager.commit{
            setReorderingAllowed(true)

            setCustomAnimations(
                R.anim.slide_from_above,
                R.anim.fade_out,
                0,
                R.anim.slide_from_below
            )

            val myArguments = Bundle()
            myArguments.putParcelable(PeopleDetailFragment.personIndexForBundle, myPerson)

            val newDetailFragment = PeopleDetailFragment()
            newDetailFragment.arguments = myArguments

            addToBackStack(null)
            replace(R.id.fragment_container_view, newDetailFragment)
        }

    }

    // OVERRIDE INTERFACE HOMEPAGE_LISTENER METHOD
    override fun onEnterButtonClicked() {


        supportFragmentManager.commit{

            setReorderingAllowed(true)
            setCustomAnimations(
                    R.anim.slide_from_right,
                    0,
                    0,
                    R.anim.slide_from_left
            )

            addToBackStack(null)

            replace(R.id.fragment_container_view, PeopleListFragment())

        }

    }


}