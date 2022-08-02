package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class VersionDetail(
    @Json(name = "rarity") val rarity:Int,
    @Json(name = "version") val version:Pokemon,
)