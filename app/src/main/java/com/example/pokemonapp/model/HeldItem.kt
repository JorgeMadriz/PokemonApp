package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class HeldItem (
    @Json(name = "item") val item:Pokemon,
    @Json(name = "version_details") val versionDetails:List<VersionDetail>,
    )