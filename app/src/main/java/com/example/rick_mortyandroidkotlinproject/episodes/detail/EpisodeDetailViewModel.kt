package com.example.rick_mortyandroidkotlinproject.episodes.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.Episode
import com.example.rick_mortyandroidkotlinproject.network.properties.Location
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EpisodeDetailViewModel(episode_id: Int): ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _episode = MutableLiveData<Episode>()
    val  episode: LiveData<Episode>
        get() = _episode

    private  var episodeId: Int = episode_id

    init {
        loadChar()

    }

    fun loadChar() {
        coroutineScope.launch {
            var getCharacterDeferred = RickAndMortyApi.retrofitService.getEpisode(episodeId)
            try {
                var result = getCharacterDeferred.await()
                _episode.value = result

            }catch (t: Throwable){

            }
        }
    }

}