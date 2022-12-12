package com.rakesh.cvbuilderapplication.data

data class Certification(
    val logo: String,
    val name: String
) {
    companion object {
        fun getListOfCertifications(): MutableList<Certification> {
            return mutableListOf(
                Certification(
                    "https://spng.subpng.com/20190111/oib/kisspng-mongodb-logo-database-nosql-postgresql-how-to-create-an-outstanding-tech-stack-clickup-bl-5c391bdf595391.1697746615472465593659.jpg",
                    "MongoDB Professional Certification"
                ),
                Certification(
                    "https://www.tenforums.com/geek/gars/images/2/types/thumb____-_ramework.png",
                    "C# .Net Professional Training"
                )
            )
        }
    }
}
