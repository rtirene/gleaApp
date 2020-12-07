package com.example.glea.presentation.intent

sealed class PokemonIntent {
    object FetchPokemonList: PokemonIntent()
    object FetchPokemonDetail: PokemonIntent()
}