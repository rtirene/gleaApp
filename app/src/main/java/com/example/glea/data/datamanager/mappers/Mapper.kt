package com.example.glea.data.datamanager.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}