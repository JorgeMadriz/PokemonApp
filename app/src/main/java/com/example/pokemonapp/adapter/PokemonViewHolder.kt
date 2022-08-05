package com.example.pokemonapp.adapter

import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentOverviewBinding
import com.example.pokemonapp.databinding.ItemPokemonrecyclerviewBinding
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.overview.OverviewFragment


class PokemonViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val binding = ItemPokemonrecyclerviewBinding.bind(view)

    fun render(pokemon: Pokemon, onClickListener: (Pokemon) -> Unit) {
        binding.pokemonName.text = pokemon.name
        binding.pokemoncard.setOnClickListener { onClickListener(pokemon) }
    }
}
