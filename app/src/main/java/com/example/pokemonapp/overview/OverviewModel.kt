package com.example.pokemonapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.network.PokemonApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {


    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getPokemonlist()
    }

    private fun getPokemonlist() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.retrofitService.getPokemon()
                _status.value = "Success: ${listResult.pokemones.size} Pokemon retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}