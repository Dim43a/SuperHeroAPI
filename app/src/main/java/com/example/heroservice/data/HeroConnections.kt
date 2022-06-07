package com.example.heroservice.data

data class HeroConnections(

    val name: String? = null,
    val groupAffiliation: String? = null,
    val relatives: String? = null
) {
    override fun toString(): String {
        return "Connections\n" +
                "Name: $name\n" +
                "Group Affiliation: $groupAffiliation\n" +
                "Relatives: $relatives\n"
    }
}
