package com.example.rick_mortyandroidkotlinproject.locations.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.Location
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LocationDetailViewModel(location_id: Int): ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _location = MutableLiveData<Location>()
    val  location: LiveData<Location>
        get() = _location

    private  var locationId: Int = location_id

    init {
        loadChar()

    }

    fun loadChar() {
        coroutineScope.launch {
            var getCharacterDeferred = RickAndMortyApi.retrofitService.getLocation(locationId)
            try {
                var result = getCharacterDeferred.await()
                _location.value = result

            }catch (t: Throwable){

            }
        }
    }
}