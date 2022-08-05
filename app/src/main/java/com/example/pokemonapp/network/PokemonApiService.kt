package com.example.pokemonapp.network

import com.example.pokemonapp.model.PokemonDetailsResponse
import com.example.pokemonapp.model.PokemonResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL =
    "https://pokeapi.co/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PokemonApiService{
    @GET("pokemon")
    suspend fun getPokemon():PokemonResponse
    @GET("pokemon/{pokemonName}/")
    suspend fun getPokemonDetails(@Path("pokemonName") pokemonName:String):PokemonDetailsResponse
}

object PokemonApi {
    val retrofitService : PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java) }
}