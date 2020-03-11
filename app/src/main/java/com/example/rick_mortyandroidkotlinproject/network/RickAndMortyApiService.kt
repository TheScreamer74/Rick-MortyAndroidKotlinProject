package com.example.rick_mortyandroidkotlinproject.network



import com.example.rick_mortyandroidkotlinproject.network.properties.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
    @GET("character/")
    fun getCharactersList():
            Deferred<RickAndMortyCharactersProperties>

    @GET("character/")
    fun getCharactersListWithPage(@Query("page") numPage: Int):
            Deferred<RickAndMortyCharactersProperties>

    @GET("character/{id}")
    fun getCharacter(@Path("id") charId: Int):
            Deferred<RickAndMortyCharacterProperties>

    @GET("location/")
    fun getLocationListWithPage(@Query("page") numPage: Int):
            Deferred<LocationsProperties>

    @GET("location/{id}")
    fun getLocation(@Path("id")locId: Int):
            Deferred<Location>

    @GET("episode/")
    fun getEpisodeListWithPage(@Query("page") numPage: Int):
            Deferred<EpisodesProperties>

    @GET("episode/{id}")
    fun getEpisode(@Path("id")locId: Int):
            Deferred<Episode>
}

object RickAndMortyApi{
    val retrofitService : RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}