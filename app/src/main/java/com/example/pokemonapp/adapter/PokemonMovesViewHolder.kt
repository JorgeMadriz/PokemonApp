package com.example.pokemonapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemMovesrecyclerviewBinding
import com.example.pokemonapp.model.Move
import com.example.pokemonapp.model.Moves


class PokemonMovesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemMovesrecyclerviewBinding.bind(view)

    fun render(moves: Moves) {
        binding.movesPokemon.text = moves.move.name
    }
}