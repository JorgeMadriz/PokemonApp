package com.example.pokemonapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.network.PokemonApi
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _pokemonObjectDetails = MutableLiveData<Pokemon>()
    val pokemonObjectDetails: LiveData<Pokemon> = _pokemonObjectDetails

    init {
        getPokemonDetalles()
    }

    private fun getPokemonDetalles() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.retrofitService.getPokemonDetails()
                println(listResult)
                _status.value = "Success: ${listResult} Mars photos retrieved"

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}