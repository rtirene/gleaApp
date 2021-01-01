package com.example.glea.presentation.ui

import android.R.attr.startX
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.withTransaction
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.glea.R
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.datamanager.network.api.PokemonDetailsApiHelperImpl
import com.example.glea.data.datamanager.network.api.PokemonListApiHelperImpl
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.domain.models.Pokemon
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonDetailState
import com.example.glea.presentation.states.PokemonListState
import com.example.glea.presentation.view_model.PokemonDetailViewModel
import com.example.glea.presentation.view_model.PokemonDetailViewModelFactory
import com.example.glea.presentation.view_model.PokemonListViewModel
import com.example.glea.presentation.view_model.PokemonListViewModelFactory
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@ExperimentalCoroutinesApi
class PokemonDetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)


        sprites_slider.setInAnimation(this, android.R.anim.fade_in)
        sprites_slider.setOutAnimation(this, android.R.anim.fade_out)
        sprites_slider.setOnClickListener(this)
        pokemon_image_detail_front.setOnClickListener(this)
        pokemon_image_detail_back.setOnClickListener(this)

        intent?.getStringExtra(EXTRA_POKEMON_NAME)?.let {
            initViewModel(it)
            observePokemonDetailState()
        }
    }

    fun initViewModel(name: String) {
        pokemonDetailViewModel = ViewModelProvider(
            this,
            PokemonDetailViewModelFactory(
                PokemonDetailsApiHelperImpl(RetrofitServiceBuilder),
                PokemonDb.create(this, true),
                PokemonDetailMapper(),
                name
            )
        ).get(PokemonDetailViewModel::class.java)
        lifecycleScope.launch {
            pokemonDetailViewModel.pokemonIntent.send(PokemonIntent.FetchPokemonDetail)
        }
    }

    private fun observePokemonDetailState() {
        lifecycleScope.launch {
            pokemonDetailViewModel.state.collect { pokemonDetailState ->
                when (pokemonDetailState) {
                    is PokemonDetailState.PokemonDetail -> {
                        showPokemonDetail(pokemonDetailState.pokemon)
                    }
                }
            }
        }
    }

    private fun showPokemonDetail(pokemon: Pokemon?) {
        pokemon?.let {
            pokemon_name.text = it.name
            Glide.with(this)
                .load(it.imgs?.frontUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokemon_image_detail_front)
            Glide.with(this)
                .load(it.imgs?.backUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokemon_image_detail_back)
        }

    }

    companion object {
        const val EXTRA_POKEMON_NAME = "EXTRA_POKEMON_NAME"
        fun getStartIntent(context: Context, name: String?): Intent {
            return Intent(context, PokemonDetailActivity::class.java).apply {
                putExtra(EXTRA_POKEMON_NAME, name)
            }
        }

    }

    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.pokemon_image_detail_front -> sprites_slider.showNext()
            p0?.id == R.id.pokemon_image_detail_back -> sprites_slider.showPrevious()
        }
    }

}