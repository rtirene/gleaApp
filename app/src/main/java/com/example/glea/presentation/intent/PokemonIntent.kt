package com.example.glea.presentation.intent

sealed class PokemonIntent {
    object FetchPokemonList: PokemonIntent()
    data class FetchFilteredPokemonList(val typeName : String) : PokemonIntent()
}