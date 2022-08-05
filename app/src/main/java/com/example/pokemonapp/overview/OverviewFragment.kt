package com.example.pokemonapp.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.R
import com.example.pokemonapp.adapter.PokemonAdapter
import com.example.pokemonapp.databinding.FragmentOverviewBinding
import com.example.pokemonapp.model.Pokemon

class OverviewFragment() : Fragment(){

    private val viewModel: OverviewViewModel by viewModels()
    private lateinit var binding:FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.pokemonObject.observe(viewLifecycleOwner){
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerViewPokemon.layoutManager = manager
            binding.recyclerViewPokemon.adapter = PokemonAdapter(it) { onItemSelected(it) }
        }
        super.onViewCreated(view, savedInstanceState)
    }
    private fun goToNextScreen(){
        findNavController().navigate(R.id.action_overviewFragment_to_detailsFragment)
    }

    fun onItemSelected(pokemon: Pokemon){
        val pokemonId = pokemon.name
        val pokemonIdUrl = pokemon.url
        println(pokemonId)
        println(pokemonIdUrl)
        goToNextScreen()
    }
}
