package com.example.rick_mortyandroidkotlinproject.network


import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharactersProperties
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface RickAndMortyApiService{
    @GET("character")
    fun getCharactersList():
            Deferred<RickAndMortyCharactersProperties>

    @GET("character/{id}")
    fun getCharacter(@Path("id") charId: Int):
            Deferred<RickAndMortyCharacterProperties>

}

object RickAndMortyApi{
    val retrofitService : RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}