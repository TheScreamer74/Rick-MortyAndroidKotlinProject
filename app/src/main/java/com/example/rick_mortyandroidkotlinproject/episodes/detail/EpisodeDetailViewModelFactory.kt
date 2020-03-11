package com.example.rick_mortyandroidkotlinproject.episodes.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EpisodeDetailViewModelFactory (private val episode_id: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EpisodeDetailViewModel::class.java)){
            return EpisodeDetailViewModel(episode_id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}