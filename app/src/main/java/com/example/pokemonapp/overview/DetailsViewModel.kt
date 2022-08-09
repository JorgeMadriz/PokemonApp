package com.example.pokemonapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.*

import com.example.pokemonapp.network.PokemonApi
import kotlinx.coroutines.launch
import java.util.Collections.list

class DetailsViewModel : ViewModel() {

    private val _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String> = _pokemonName

    private val _pokemonId = MutableLiveData<String>()
    val pokemonInt:LiveData<String> =_pokemonId

    private val _pokemonType= MutableLiveData<List<Tipo>>()
    val pokemonType:LiveData<List<Tipo>> = _pokemonType

    private val _pokemonMoves= MutableLiveData<List<Moves>>()
    val pokemonMoves:LiveData<List<Moves>> = _pokemonMoves

    private val _sprite = MutableLiveData<Sprites>()
    val sprites: LiveData<Sprites> = _sprite



    fun getPokemonDetalles(path:String) {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.retrofitService.getPokemonDetails(path)
                _sprite.value = listResult.sprites
                _pokemonName.value = listResult.name
                _pokemonId.value = listResult.id.toString()
                _pokemonMoves.value = listResult.moves
                _pokemonType.value = listResult.types

            } catch (e: Exception) {
                _pokemonName.value = "Failure: ${e.message}"
            }
        }
    }
}