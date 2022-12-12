package com.rakesh.cvbuilderapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.rakesh.cvbuilderapplication.R
import com.rakesh.cvbuilderapplication.constants.AppConstants
import com.rakesh.cvbuilderapplication.constants.AppConstants.USERNAME
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var tv_userName: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeView(view)
    }

    private fun initializeView(view: View) {
        val addfloatingButton = view.findViewById<FloatingActionButton>(R.id.floating_add_button)
        tv_userName = view.findViewById(R.id.tv_username)

        val sharedPref = requireActivity().getSharedPreferences(AppConstants.PREFERRED_NAME, 0)
        val userName = sharedPref.getString(USERNAME, "")

        tv_userName.text = userName

        addfloatingButton.setOnClickListener {
            Snackbar.make(view, "Add other home page items", Snackbar.LENGTH_LONG).show()
        }

    }






    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}