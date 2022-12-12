package com.rakesh.cvbuilderapplication.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rakesh.cvbuilderapplication.ui.aboutMe.AboutMeFragment
import com.rakesh.cvbuilderapplication.ui.contact.ContactFragment
import com.rakesh.cvbuilderapplication.ui.home.HomeFragment
import com.rakesh.cvbuilderapplication.ui.workExperience.WorkExperienceFragment

class MainAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // fixed item size, we have tab item is 4

    override fun createFragment(position: Int): Fragment {

        //creating fragment object according to position
        val fragment: Fragment = when(position) {
            0 -> HomeFragment.newInstance()

            1 -> AboutMeFragment.newInstance()

            2 -> WorkExperienceFragment.newInstance()

            3 -> ContactFragment.newInstance()

            else -> HomeFragment.newInstance()
        }

        return fragment
    }

}