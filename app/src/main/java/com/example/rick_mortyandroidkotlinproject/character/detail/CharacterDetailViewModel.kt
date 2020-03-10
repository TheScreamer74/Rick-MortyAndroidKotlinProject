package com.example.rick_mortyandroidkotlinproject.character.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import kotlinx.coroutines.*

class CharacterDetailViewModel (character_id: Int): ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _character = MutableLiveData<RickAndMortyCharacterProperties>()
    val  character: LiveData<RickAndMortyCharacterProperties>
        get() = _character

    private  var characterId: Int = character_id

    init {
        loadChar()

    }

    fun loadChar() {
        coroutineScope.launch {
            var getCharacterDeferred = RickAndMortyApi.retrofitService.getCharacter(characterId)
            try {
                var result = getCharacterDeferred.await()
                _character.value = result

            }catch (t: Throwable){

            }
        }
    }

}