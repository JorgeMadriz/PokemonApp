package com.example.pokemonapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.model.Move
import com.example.pokemonapp.model.Moves

class PokemonMovesAdapter(val pokemoneMoves:List<Moves>) : RecyclerView.Adapter<PokemonMovesViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonMovesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return PokemonMovesViewHolder(layoutInflater.inflate(R.layout.item_movesrecyclerview, parent, false))
        }

        override fun onBindViewHolder(holder: PokemonMovesViewHolder, position: Int) {
            val item = pokemoneMoves[position]
            holder.render(item)
        }

        override fun getItemCount(): Int {
            return pokemoneMoves.size
        }
}