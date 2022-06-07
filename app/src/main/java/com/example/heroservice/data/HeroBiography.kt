package com.example.heroservice.data

import org.json.JSONArray

data class HeroBiography(
    var fullName: String? = null,
    var alterEgos: String? = null,
    var aliases: JSONArray? = null,
    val placeOfBirth: String? = null,
    val firstAppearance: String? = null,
    val publisher: String? = null,
    val alignment: String? = null
){
    override fun toString(): String {
        return "Biography\n" +
                "Full Name: $fullName\n" +
                "Alter Egos: $alterEgos\n" +
                "Aliases: $aliases\n" +
                "Place of Birth: $placeOfBirth\n" +
                "First Appearance: $firstAppearance\n" +
                "Publisher: $publisher\n" +
                "Alignment: $alignment"
    }
}

