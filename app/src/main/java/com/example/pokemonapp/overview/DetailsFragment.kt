package com.example.pokemonapp.overview

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pokemonapp.adapter.PokemonMovesAdapter
import com.example.pokemonapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding: FragmentDetailsBinding

    val args: DetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pokemonName = args.pokemonName
        viewModel.getPokemonDetalles(pokemonName)

        viewModel.pokemonType.observe(viewLifecycleOwner){
            binding.nombreTipo.text= it[0].type.name
        }

        viewModel.pokemonName.observe(viewLifecycleOwner){
            binding.pokemonName.text =it
        }
        viewModel.pokemonInt.observe(viewLifecycleOwner){
            binding.numeroPokemon.text= it.toString()
        }
        viewModel.sprites.observe(viewLifecycleOwner){
            val imageView = binding.imagePokemon
            Glide.with(this).load(it.frontDefault).into(imageView)
        }

        viewModel.pokemonMoves.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerMoves.layoutManager = manager
            binding.recyclerMoves.adapter = PokemonMovesAdapter(it)
        }
    }
}
