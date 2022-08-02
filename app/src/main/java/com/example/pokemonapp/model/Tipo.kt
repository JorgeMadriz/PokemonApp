package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Tipo (
    @Json(name = "slot") val slot:Int,
    @Json(name = "type") val type:Pokemon
        )