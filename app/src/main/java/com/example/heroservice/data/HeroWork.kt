package com.example.heroservice.data

data class HeroWork(
    val name: String? = null,
    val occupation: String? = null,
    val base: String? = null
) {
    override fun toString(): String {
        return "Work\n" +
                "Name: $name\n" +
                "Occupation: $occupation\n" +
                "Base: $base"
    }
}

