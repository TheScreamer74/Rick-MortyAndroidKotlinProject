package com.example.rick_mortyandroidkotlinproject.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties

class CharacterListAdapter: RecyclerView.Adapter<CharacterItemViewHolder>(){

    val data = listOf<RickAndMortyCharacterProperties>()
    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int){
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterItemViewHolder(inflater, parent)
    }
}