package com.example.rick_mortyandroidkotlinproject.locations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LocationDetailViewModelFactory(private val location_id: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LocationDetailViewModel::class.java)){
            return LocationDetailViewModel(location_id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}