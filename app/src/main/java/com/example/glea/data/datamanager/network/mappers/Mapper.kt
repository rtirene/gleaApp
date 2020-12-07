package com.example.glea.datamanager.network.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}