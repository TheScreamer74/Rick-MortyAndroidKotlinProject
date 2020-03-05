package com.example.rick_mortyandroidkotlinproject.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import com.squareup.picasso.Picasso

class CharacterItemViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.character_item_view, parent, false)) {
        private var nameCharView: TextView? = null
        private var imageCharView: ImageView? = null


        init {
            nameCharView = itemView.findViewById(R.id.name_char)
            imageCharView = itemView.findViewById(R.id.image_char)
        }

        fun bind(character: RickAndMortyCharacterProperties) {
            nameCharView?.text = character.name
            Picasso.get().load(character.image).into(imageCharView)
        }

    }