package com.example.rick_mortyandroidkotlinproject.character.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharacterDetailViewModelFactory (private val character_id: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CharacterDetailViewModel::class.java)){
            return CharacterDetailViewModel(character_id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}