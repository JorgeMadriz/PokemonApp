package com.example.pokemonapp.model

import com.squareup.moshi.Json

data class VersionGroupDetali (
    @Json(name ="level_learned_at") val levelLearnedAt: Int,
    /*@Json(name = "move_learn_method") val moveLearnMethod:Pokemon,
    @Json(name = "version_group") val versionGroup:Pokemon
*/
)