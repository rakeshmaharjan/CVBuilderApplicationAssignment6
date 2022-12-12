package com.rakesh.cvbuilderapplication.ui.workExperience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rakesh.cvbuilderapplication.R
import com.rakesh.cvbuilderapplication.data.WorkExperience

class WorkExperienceAdapter(
    private val workExperienceList: MutableList<WorkExperience> = mutableListOf()
) : RecyclerView.Adapter<WorkExperienceAdapter.WorkViewHolder>(){

    inner class WorkViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(workExperience: WorkExperience) {
            val logoImageView: ImageView = view.findViewById(R.id.logo_image_view)
            val companyNameTextView: TextView = view.findViewById(R.id.company_name_text_view)
            val durationTextView: TextView = view.findViewById(R.id.duration_text_view)
            val locationTextView: TextView = view.findViewById(R.id.location_text_view)
            val rolesTextView: TextView = view.findViewById(R.id.roles_text_view)

            Glide.with(view.context).load(workExperience.logo).into(logoImageView)
            companyNameTextView.text = workExperience.companyName
            durationTextView.text = workExperience.fromDate + " - " + workExperience.toDate
            locationTextView.text = workExperience.location
            rolesTextView.text = workExperience.roles
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
        return WorkViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(workExperienceList[position])
    }

    override fun getItemCount(): Int = workExperienceList.size
}