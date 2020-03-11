package com.example.rick_mortyandroidkotlinproject.locations.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentDetailLocationBinding

class LocationDetailFragment: Fragment() {
    private lateinit var viewModel: LocationDetailViewModel
    private lateinit var viewModelFactory: LocationDetailViewModelFactory

    private lateinit var binding: FragmentDetailLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_location,
            container,
            false
        )


        val args = arguments?.let { LocationDetailFragmentArgs.fromBundle(it) }

        viewModelFactory = LocationDetailViewModelFactory(args?.locationId?: 1)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LocationDetailViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}