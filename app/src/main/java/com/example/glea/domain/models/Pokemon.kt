package com.example.glea.domain.models

data class Pokemon(
    val name: String?,
    val imgs: Images? = null,
    val stats: List<Stat?>? = null,
    val type: List<Type?>? = null
)