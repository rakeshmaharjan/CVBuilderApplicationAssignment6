package com.rakesh.cvbuilderapplication.ui.aboutMe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.cvbuilderapplication.R
import com.rakesh.cvbuilderapplication.data.Certification
import com.rakesh.cvbuilderapplication.data.Education

class AboutMeFragment : Fragment(R.layout.fragment_aboutme) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeEducation(view)
        initializeCertification(view)
    }

    private fun initializeEducation(view: View) {
        val rv_education = view.findViewById<RecyclerView>(R.id.rv_education)
        val eduAdapter = EducationAdapter(Education.getListOfEducation())
        rv_education.adapter = eduAdapter
    }

    private fun initializeCertification(view: View) {
        val rv_certification = view.findViewById<RecyclerView>(R.id.rv_certification)
        val certAdapter = CertificationAdapter(Certification.getListOfCertifications())
        rv_certification.adapter = certAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutMeFragment()
    }
}