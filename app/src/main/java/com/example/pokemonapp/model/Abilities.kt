package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Abilities(
    @Json(name = "ability") val ability:Ability,
    @Json(name = "is_hidden") val isHidden: Boolean,
    @Json(name = "slot")val slot:Int
    )