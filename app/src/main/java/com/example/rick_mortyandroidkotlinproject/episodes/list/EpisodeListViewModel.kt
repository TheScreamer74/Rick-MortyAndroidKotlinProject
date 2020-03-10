package com.example.rick_mortyandroidkotlinproject.episodes.list

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.Episode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EpisodeListViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _page = MutableLiveData<Int>()
    val page : LiveData<Int>
        get() = _page


    private val _pages = MutableLiveData<Int>()
    val pages : LiveData<Int>
        get() = _pages

    private val _episodes = MutableLiveData<List<Episode>>()
    val episodes : LiveData<List<Episode>>
        get() = _episodes

    init{
        _page.value = 1
        LoadEpisodeList()
    }

    private fun LoadEpisodeList() {
        coroutineScope.launch {
            var getCharactersListDeferred = RickAndMortyApi.retrofitService.getEpisodeListWithPage(page.value?: 1)
            try {
                var result = getCharactersListDeferred.await()
                _episodes.value = result.results
                _pages.value = result.info.pages
            }
            catch(t: Throwable){
                Log.i("LocationListViewModel", t.message)
            }
        }
    }

    fun nextPage(view: View){
        _page.value = page.value?.plus(1)
        LoadEpisodeList()
        if (page.value == pages.value){
            view.isEnabled = false
        }
    }

    fun previousPage(view: View){

        _page.value = page.value?.minus(1)
        LoadEpisodeList()
        if (page.value == 1){
            view.isEnabled = false
        }
    }
}