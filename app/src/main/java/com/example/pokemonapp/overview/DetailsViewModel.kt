package com.example.pokemonapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.model.PokemonDetailsResponse
import com.example.pokemonapp.network.PokemonApi
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    val pathPokemon = "ditto"

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _pokemonObjectDetails = MutableLiveData<PokemonDetailsResponse>()
    val pokemonObjectDetails: LiveData<PokemonDetailsResponse> = _pokemonObjectDetails

    init {
        getPokemonDetalles()
    }

    private fun getPokemonDetalles() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.retrofitService.getPokemonDetails(pathPokemon)
                _status.value = "Success: ${listResult} retrieved"

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}