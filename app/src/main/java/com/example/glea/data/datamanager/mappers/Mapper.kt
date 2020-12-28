package com.example.glea.data.datamanager.network.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}