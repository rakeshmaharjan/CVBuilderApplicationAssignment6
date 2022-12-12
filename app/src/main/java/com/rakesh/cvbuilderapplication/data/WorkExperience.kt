package com.rakesh.cvbuilderapplication.data

data class WorkExperience(
    val companyName: String,
    val fromDate: String,
    val toDate: String,
    val location: String,
    val logo: String,
    val roles: String
) {
    companion object {
        fun getWorkExperienceList() : MutableList<WorkExperience> {
            return mutableListOf(
                WorkExperience(
                    "Creatrix Technology",
                    "Oct 2020",
                    "Dec 2021",
                    "SanDiego, CA",
                    "https://www.creatrix.com.np/assets/img/logo.png",
                    "developed social engagement application"
                ),
                WorkExperience(
                    "AQORE SOFTWARE",
                    "Oct 2016",
                    "Oct 2020",
                    "Kathmandu, Nepal",
                    "https://media.licdn.com/dms/image/C510BAQGpOI2uRcaIoQ/company-logo_200_200/0/1531120597509?e=1678924800&v=beta&t=GufTDHwhwS61zp2Ef1EvYrru8wDME9KdVzDXXy-mjyc",
                    "Developed new and customized modules for Staffing and Recruitment System based on project needs."
                ),
                WorkExperience(
                    "FINACCESS",
                    "Dec 2013",
                    "Oct 2016",
                    "Lalitpur, Nepal",
                    "https://media.licdn.com/dms/image/C4E0BAQFDt6zV89Jnyg/company-logo_200_200/0/1519882564302?e=1678924800&v=beta&t=s6eSocJYOammSD6N2WtqdaM7e9HWDOy6EksGt9WnT6Q",
                    "Enhanced SMS gateway, AMI/AGI IVR system, and web applications used by commercial banks."
                ),
            )
        }
    }
}
