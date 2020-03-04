package com.example.rick_mortyandroidkotlinproject.network.properties



data class RickAndMortyCharactersProperties (
    val info: InfoProperties,
    val results: List<RickAndMortyCharacterProperties>
)
