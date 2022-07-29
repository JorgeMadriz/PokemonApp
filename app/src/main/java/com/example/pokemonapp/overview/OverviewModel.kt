package com.example.pokemonapp.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.network.PokemonApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _pokemonObject = MutableLiveData<List<Pokemon>>()
    val pokemonObject: LiveData<List<Pokemon>> = _pokemonObject

    init {
        getPokemonlist()
    }

    private fun getPokemonlist() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.retrofitService.getPokemon()
                _pokemonObject.value= listResult.pokemones
                _status.value = "Success: List Pokemon retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}





