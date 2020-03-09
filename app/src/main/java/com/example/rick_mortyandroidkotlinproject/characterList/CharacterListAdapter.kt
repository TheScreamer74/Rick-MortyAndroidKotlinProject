package com.example.rick_mortyandroidkotlinproject.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.databinding.CharacterItemViewBinding
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties

class CharacterListAdapter: ListAdapter<RickAndMortyCharacterProperties, CharacterListAdapter.CharacterItemViewHolder>(DiffCallback) {

    class CharacterItemViewHolder(private var binding: CharacterItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (rickAndMortyCharacterProperties: RickAndMortyCharacterProperties){
            binding.character = rickAndMortyCharacterProperties
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RickAndMortyCharacterProperties>(){
        override fun areItemsTheSame(
            oldItem: RickAndMortyCharacterProperties,
            newItem: RickAndMortyCharacterProperties
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: RickAndMortyCharacterProperties,
            newItem: RickAndMortyCharacterProperties
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterItemViewHolder {
       return CharacterItemViewHolder(CharacterItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: CharacterItemViewHolder,
        position: Int
    ) {
        val rickAndMortyCharacterProperties = getItem(position)
        holder.bind(rickAndMortyCharacterProperties)
    }
}