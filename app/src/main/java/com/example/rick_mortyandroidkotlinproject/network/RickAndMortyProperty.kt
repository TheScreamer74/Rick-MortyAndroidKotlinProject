package com.example.rick_mortyandroidkotlinproject.network

import org.json.JSONArray
import org.json.JSONObject

data class RickAndMortyProperty (
    val header: JSONObject,
    val results: JSONArray
)
