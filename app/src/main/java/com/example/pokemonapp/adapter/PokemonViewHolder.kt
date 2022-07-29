package com.example.pokemonapp.adapter

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonrecyclerviewBinding
import com.example.pokemonapp.model.Pokemon


class PokemonViewHolder(view:View):RecyclerView.ViewHolder(view){

    val binding = ItemPokemonrecyclerviewBinding.bind(view)

    fun render (pokemon: Pokemon){
        binding.pokemonName.text = pokemon.name
    }
}