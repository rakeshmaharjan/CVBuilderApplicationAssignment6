package com.rakesh.cvbuilderapplication.ui.workExperience

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.cvbuilderapplication.R
import com.rakesh.cvbuilderapplication.data.WorkExperience

class WorkExperienceFragment : Fragment(R.layout.fragment_workexperience) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv_workExperience: RecyclerView = view.findViewById(R.id.rv_workExperience)

        val adapter = WorkExperienceAdapter(WorkExperience.getWorkExperienceList())

        rv_workExperience.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkExperienceFragment()
    }
}