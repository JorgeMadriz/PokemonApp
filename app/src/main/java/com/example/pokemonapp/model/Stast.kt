package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Stast (
    @Json(name = "base_stat")val baseStat: Int,
    @Json(name="effort")val effort: Int,
    @Json(name = "stat")val stat:Stat

)