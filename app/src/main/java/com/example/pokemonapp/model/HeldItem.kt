package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class HeldItem (
    @Json(name = "item") val item:Item,
    @Json(name = "version_details") val versionDetails:List<VersionDetail>,
    )