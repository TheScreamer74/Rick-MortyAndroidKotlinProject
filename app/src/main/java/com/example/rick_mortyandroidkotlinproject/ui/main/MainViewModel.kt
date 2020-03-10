package com.example.rick_mortyandroidkotlinproject.ui.main

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
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

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response


    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name

    private val _origin = MutableLiveData<String>()
    val origin : LiveData<String>
        get() = _origin

    private val _gender = MutableLiveData<String>()
    val  gender : LiveData<String>
        get() = _gender

    private val _specie = MutableLiveData<String>()
    val specie : LiveData<String>
        get() = _specie

    private val _lastLocation = MutableLiveData<String>()
    val lastLocation : LiveData<String>
        get() = _lastLocation

    private val _status = MutableLiveData<String>()
    val status : LiveData<String>
        get() = _status

    private val _image = MutableLiveData<String>()
    val image : LiveData<String>
        get() = _image

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
                _name.value = result.name
                _status.value = result.status
                _gender.value = result.gender
                _image.value = result.image
                _lastLocation.value = result.location.name
                _specie.value = result.species
                _origin.value = result.origin.name

            }catch (t: Throwable){

            }
        }
    }

    fun switchOnCharacterListFragment(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_characterListFragment)
    }

    fun switchOnLocationListFragment(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_locationListFragment)

    }

    fun switchOnEpisodeListFragment(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_episodeListFragment)

    }
}
