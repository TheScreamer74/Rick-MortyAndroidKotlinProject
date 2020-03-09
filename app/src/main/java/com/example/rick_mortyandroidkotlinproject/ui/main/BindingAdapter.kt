package com.example.rick_mortyandroidkotlinproject.ui.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.characterList.CharacterListAdapter
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import com.squareup.picasso.Picasso

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<RickAndMortyCharacterProperties>?){
    val adapter = recyclerView.adapter as CharacterListAdapter
    adapter.submitList(data)
}

@BindingAdapter("image")
fun bindImage(imgView: ImageView, imgUrl: String?) {
        Picasso.get()
            .load(imgUrl)
            .into(imgView)
    }
