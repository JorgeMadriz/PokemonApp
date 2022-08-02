package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class Moves (
    @Json(name = "move") val move:Pokemon,
    @Json(name= "version_group_details") val versionGroupDetalis:List<VersionGroupDetali>,
        )