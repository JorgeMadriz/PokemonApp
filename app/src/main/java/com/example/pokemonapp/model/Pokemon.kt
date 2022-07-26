package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
    )

