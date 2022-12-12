package com.rakesh.cvbuilderapplication.ui.contact

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rakesh.cvbuilderapplication.WebActivity
import com.rakesh.cvbuilderapplication.R


class ContactFragment : Fragment(R.layout.fragment_contact), OnClickListener {

    private lateinit var link_phone: LinearLayout
    private lateinit var link_email: LinearLayout
    private lateinit var link_linkedIn: LinearLayout
    private lateinit var link_github: LinearLayout
    private lateinit var link_resume: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        link_phone = view.findViewById(R.id.link_mobile)
        link_email = view.findViewById(R.id.link_email)
        link_linkedIn = view.findViewById(R.id.link_linkedin)
        link_github = view.findViewById(R.id.link_github)
        link_resume = view.findViewById(R.id.link_resume)

        link_phone.setOnClickListener(this)
        link_email.setOnClickListener(this)
        link_linkedIn.setOnClickListener(this)
        link_github.setOnClickListener(this)
        link_resume.setOnClickListener(this)

    }

    private fun onClickMobile() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+16418192416"))
        context?.startActivity(intent)
    }

    private fun onClickEmail() {
        sendEmail()
    }

    private fun onClickLinkedIn() {
        openWebUrl(getString(R.string.linkedin_profile))
    }

    private fun onClickGithub() {
        openWebUrl(getString(R.string.github_profile))
    }

    private fun onClickResume() {

    }

    private fun openWebUrl(url: String) {
        val intent = Intent(requireActivity(), WebActivity::class.java)
        intent.putExtra("url",url)
        requireContext().startActivity(intent)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.link_mobile -> onClickMobile()
            R.id.link_email -> onClickEmail()
            R.id.link_linkedin -> onClickLinkedIn()
            R.id.link_github -> onClickGithub()
            R.id.link_resume -> onClickResume()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactFragment()
    }


    private fun sendEmail() {
        val isAppInstalled: Boolean = CheckIfApplicationIsAvailable("com.google.android.gm")
        if (isAppInstalled) {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = (Uri.parse("mailto:" + getString(R.string.email)))
            emailIntent.type = "text/plain"
            emailIntent.setPackage("com.google.android.gm")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email))
            startActivity(Intent.createChooser(emailIntent, "Share with"))
        } else {
            Toast.makeText(requireContext(), "App not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun CheckIfApplicationIsAvailable(appName: String?): Boolean {
        return try {
            requireContext().packageManager.getPackageInfo(appName!!, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

}