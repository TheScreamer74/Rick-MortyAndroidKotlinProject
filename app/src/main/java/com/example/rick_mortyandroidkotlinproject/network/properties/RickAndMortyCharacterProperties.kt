package com.example.rick_mortyandroidkotlinproject.network.properties

import com.example.rick_mortyandroidkotlinproject.classes.LocationBrief
import com.example.rick_mortyandroidkotlinproject.classes.Origin

class RickAndMortyCharacterProperties(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: LocationBrief,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
    )