package com.example.rick_mortyandroidkotlinproject.ui.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.characterList.CharacterListAdapter
import com.example.rick_mortyandroidkotlinproject.episodes.list.EpisodeListAdapter
import com.example.rick_mortyandroidkotlinproject.locations.list.LocationListAdapter
import com.example.rick_mortyandroidkotlinproject.network.properties.Episode
import com.example.rick_mortyandroidkotlinproject.network.properties.Location
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import com.squareup.picasso.Picasso

@BindingAdapter("listDataCharacter")
fun bindRecyclerViewCharacter(recyclerView: RecyclerView, data: List<RickAndMortyCharacterProperties>?){
    val adapter = recyclerView.adapter as CharacterListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataLocation")
fun bindRecyclerViewLocations(recyclerView: RecyclerView, data: List<Location>?){
    val adapter = recyclerView.adapter as LocationListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataEpisode")
fun bindRecyclerViewEpisodes(recyclerView: RecyclerView, data: List<Episode>?){
    val adapter = recyclerView.adapter as EpisodeListAdapter
    adapter.submitList(data)
}

@BindingAdapter("image")
fun bindImage(imgView: ImageView, imgUrl: String?) {
        Picasso.get()
            .load(imgUrl)
            .into(imgView)
    }
