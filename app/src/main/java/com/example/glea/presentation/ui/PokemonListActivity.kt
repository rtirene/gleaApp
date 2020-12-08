package com.example.glea.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.glea.R
import com.example.glea.datamanager.PokemonListDm
import com.example.glea.datamanager.network.mappers.PokemonListMapper
import com.example.glea.datamanager.network.service.RetrofitServiceBuilder
import com.example.glea.domain.models.Pokemon
import com.example.glea.presentation.adapter.PokemonListAdapter
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonListState
import com.example.glea.presentation.view_model.PokemonListViewModel
import com.example.glea.presentation.view_model.PokemonListViewModelFactory
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class PokemonListActivity : AppCompatActivity(), PokemonListAdapter.OnPokemonSelectedListener {

    private val adapter: PokemonListAdapter = PokemonListAdapter()
    private lateinit var pokemonListViewModel: PokemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        recycler_pokemon.adapter = adapter
        adapter.pokemonSelectedListener = this
        initViewModel()
        observePokemonListState()
    }

    private fun initViewModel() {
        pokemonListViewModel = ViewModelProvider(
            this,
            PokemonListViewModelFactory(
                PokemonListDm(
                    PokemonListMapper,
                    RetrofitServiceBuilder
                )
            )
        ).get(PokemonListViewModel::class.java)
        lifecycleScope.launch {
            pokemonListViewModel.pokemonIntent.send(PokemonIntent.FetchPokemonList)

        }
    }

    private fun observePokemonListState() {
        lifecycleScope.launch {
            pokemonListViewModel.state.collect { pokemonListState ->
                when (pokemonListState) {
                    is PokemonListState.PokemonList -> {
                        renderPokemonList(pokemonListState.pokeList)
                    }
                    is PokemonListState.Error -> {
                        error_text.visibility = View.VISIBLE
                        error_text.text = pokemonListState.error
                    }
                }
            }
        }
    }

    fun renderPokemonList(pokemonList: List<Pokemon>?) {
        pokemonList?.let {
            adapter.pokemonList = it
        }
    }

    override fun onPokemonSelected(name: String?) {
        //todo start detail activity passing p name
    }
}
