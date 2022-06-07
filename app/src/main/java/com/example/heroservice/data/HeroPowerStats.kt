package com.example.heroservice.data

data class HeroPowerStats(
    var name: String? = null,
    var intelligence: String? = null,
    var strength: String? = null,
    var speed: String? = null,
    var durability: String? = null,
    var power: String? = null,
    var combat: String? = null
) {
    override fun toString(): String {
        return "Power\n" +
                "Name: $name\n" +
                "Intelligence: $intelligence\n" +
                "Strength: $strength\n" +
                "Speed: $speed\n" +
                "Durability: $durability\n" +
                "Power: $power\n" +
                "Combat: $combat"
    }
}
