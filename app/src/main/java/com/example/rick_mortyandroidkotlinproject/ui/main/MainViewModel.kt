package com.example.rick_mortyandroidkotlinproject.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyApi
import com.example.rick_mortyandroidkotlinproject.network.RickAndMortyProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

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

        _name.value = "Rick Sanchez"
        _origin.value = "Earth"
        _gender.value = "Male"
        _specie.value = "Human"
        _lastLocation.value = "Earth"
        _status.value = "Alive"
        _image.value = "https://pbs.twimg.com/profile_images/915135928540295168/sSbUnbF3_400x400.jpg"
    }

    private fun getTotalCharacter() {

        coroutineScope.launch {
            var getPropertiesDeferred = RickAndMortyApi.retrofitService.getProperties()
            try {
                var result = getPropertiesDeferred.await()
                _response.value = "Success: ${result.toString()} blblbl"
            }
            catch(t: Throwable){
                _response.value = "Failure" + t.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "GameViewModel destroyed")
    }

    fun onNewSearch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
