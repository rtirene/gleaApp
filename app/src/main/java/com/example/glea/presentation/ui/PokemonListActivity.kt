package com.example.glea.presentation.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.glea.R
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonDetailsApiHelperImpl
import com.example.glea.data.datamanager.network.api.PokemonListApiHelperImpl
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder
import com.example.glea.domain.models.Pokemon
import com.example.glea.presentation.adapter.PokemonListAdapter
import com.example.glea.presentation.adapter.PokemonLoadStateAdapter
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonListState
import com.example.glea.presentation.view_model.PokemonListViewModel
import com.example.glea.presentation.view_model.PokemonListViewModelFactory
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalCoroutinesApi
class PokemonListActivity : AppCompatActivity(), PokemonListAdapter.OnPokemonSelectedListener {

    private val adapter: PokemonListAdapter = PokemonListAdapter()
    private lateinit var pokemonListViewModel: PokemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        initAdapter()
        initViewModel()
        //observePokemonListState()
    }

    private fun initAdapter() {
        recycler_pokemon.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PokemonLoadStateAdapter { adapter.retry() },
            footer = PokemonLoadStateAdapter { adapter.retry() }
        )
        adapter.pokemonSelectedListener = this


    }

    private fun initViewModel() {
        pokemonListViewModel = ViewModelProvider(
            this,
            PokemonListViewModelFactory(
                PokemonListApiHelperImpl(RetrofitServiceBuilder),
                PokemonDetailsApiHelperImpl(RetrofitServiceBuilder),
                PokemonDb.create(this, false),
                PokemonDetailMapper()
            )
        ).get(PokemonListViewModel::class.java)
        lifecycleScope.launch {
            pokemonListViewModel.pokemonIntent.send(PokemonIntent.FetchPokemonList)
            observePokemonListState()

        }
    }

    private fun observePokemonListState() {
        lifecycleScope.launch {
            pokemonListViewModel.state.collect { pokemonListState ->
                when (pokemonListState) {
                    is PokemonListState.PokemonList -> {
                        pokemonListState.pokeList.collectLatest {
                            adapter.submitData(it)
                        }
                    }
                }
            }
        }
    }


    override fun onPokemonSelected(pokemon: Pokemon?) {
        //todo start bottom sheet fragment passing pokemon detailed info
        val pokemonDetailFragment = PokemonDetailFragment.newInstance(pokemon)
        pokemonDetailFragment.show(supportFragmentManager, PokemonDetailFragment.TAG)
    }
}

