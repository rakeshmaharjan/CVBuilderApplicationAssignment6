package com.rakesh.cvbuilderapplication.data

data class Education(
    val collegeName: String,
    val program: String,
    val logo: String
) {

    companion object {
        fun getListOfEducation() : MutableList<Education> {
            return mutableListOf(
                Education(
                    "Maharishi Internation University",
                    "Master's in Computer Science",
                    "https://maharishischool.org/wp-content/uploads/MaharishiSchoolTreeLogo-8cc541-green.jpg"
                ),
                Education(
                    "Kantipur Engineering Engineering",
                    "Bachelor's in Computer Engineering",
                    "https://kec.edu.np/wp-content/uploads/2016/04/logo.png"
                )
            )
        }
    }
}
