package com.example.pokemonapp.model

import com.squareup.moshi.Json
import java.net.IDN

data class PokemonDetailsResponse (
    //@Json(name = "abilities")val abilities: List<Abilities>,
    //@Json(name = "base_experience") val baseExperience: Int,
    //@Json(name = "forms") val forms: List<Forms>,
   // @Json(name = "game_indices")val gameIndices:List<GameIndice>,
   // @Json(name = "height")val height:Int,
    //@Json(name = "held_items")val heldItems:List<HeldItem>,
    @Json(name = "id")val id: Int,
    //@Json(name = "is_default")val isDefault:Boolean,
   // @Json(name = "location_area_encounters")val locationAreaEncounters:String,
    @Json(name = "moves")val moves:List<Moves>,
    @Json(name = "name")val name: String,
    @Json(name = "order")val order: Int,
    //@Json(name = "past_types")val pastTypes:List<String>,
   // @Json(name = "species")val species: Species,
    //@Json(name = "sprites")val sprites: List<String>,
    @Json(name = "stats")val stats: List<Stast>,
    @Json(name = "types")val types:List<Tipo>,
    //@Json(name = "weight")val weight:Int
    )