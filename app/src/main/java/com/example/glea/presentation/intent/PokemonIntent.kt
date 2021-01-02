package com.example.glea.presentation.intent

sealed class PokemonIntent {
    //TODO prevedere loading state per il caricamento iniziale!!!!
    object FetchPokemonList: PokemonIntent()
}