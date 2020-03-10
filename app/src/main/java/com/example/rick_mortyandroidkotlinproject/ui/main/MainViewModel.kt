package com.example.rick_mortyandroidkotlinproject.ui.main


import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.properties.RickAndMortyCharacterProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    private val _character = MutableLiveData<RickAndMortyCharacterProperties>()
    val  character: LiveData<RickAndMortyCharacterProperties>
        get() = _character


    init{
        getTotalCharacter()
        generateRandomChar()
    }

     fun getTotalCharacter() {
        coroutineScope.launch {

            var getCharactersListDeferred = RickAndMortyApi.retrofitService.getCharactersList()
            try {
                var result = getCharactersListDeferred.await()
                _count.value = result.info.count
            }
            catch(t: Throwable){

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun generateRandomChar() {
        coroutineScope.launch {
            var getCharacterDeferred = RickAndMortyApi.retrofitService.getCharacter((1..(count.value?: 1)).random())
            try {
                var result = getCharacterDeferred.await()
                _character.value = result

            }catch (t: Throwable){

            }
        }
    }

    fun switchOnCharacterListFragment(view: View) {
        view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToCharacterListFragment())
    }

    fun switchOnLocationListFragment(view: View) {
        view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToLocationListFragment())

    }

    fun switchOnEpisodeListFragment(view: View) {
        view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToEpisodeListFragment())

    }

    fun switchOnCharacterDetailFragment(view: View) {
        view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToCharacterDetailFragment(character.value?.id?: 1))

    }
}
