package com.example.rick_mortyandroidkotlinproject.characterList

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _page = MutableLiveData<Int>()
    val page : LiveData<Int>
        get() = _page


    private val _pages = MutableLiveData<Int>()
    val pages : LiveData<Int>
        get() = _pages

    private val _characters = MutableLiveData<List<RickAndMortyCharacterProperties>>()
    val characters : LiveData<List<RickAndMortyCharacterProperties>>
        get() = _characters

    init{
        _page.value = 1
        LoadCharacterList()
    }

    private fun LoadCharacterList() {
        coroutineScope.launch {
            var getCharactersListDeferred = RickAndMortyApi.retrofitService.getCharactersListWithPage(page.value?: 1)
            try {
                var result = getCharactersListDeferred.await()
                _characters.value = result.results
                _pages.value = result.info.pages
            }
            catch(t: Throwable){

            }
        }
    }

     fun nextPage(view: View){
        _page.value = page.value?.plus(1)
        LoadCharacterList()
        if (page.value == pages.value){
            view.isEnabled = false
        }
    }

     fun previousPage(view: View){

        _page.value = page.value?.minus(1)
        LoadCharacterList()
        if (page.value == 1){
            view.isEnabled = false
        }
    }
}