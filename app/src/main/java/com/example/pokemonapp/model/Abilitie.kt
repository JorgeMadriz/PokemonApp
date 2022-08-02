package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Abilitie(
    @Json(name = "ability") val ability:Pokemon,
    @Json(name = "is_hidden") val isHidden: Boolean,
    @Json(name = "slot")val slot:Int
    )