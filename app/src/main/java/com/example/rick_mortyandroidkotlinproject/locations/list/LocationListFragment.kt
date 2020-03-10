package com.example.rick_mortyandroidkotlinproject.locations.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentListLocationsBinding

class LocationListFragment : Fragment() {

    companion object {
        fun newInstance() = LocationListFragment()
    }

    private lateinit var viewModel: LocationListViewModel

    private lateinit var binding: FragmentListLocationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_locations,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LocationListViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.locationList.adapter = LocationListAdapter()

        binding.fragmentListLocationBtnNext.setOnClickListener{
            viewModel.nextPage(it)
            binding.fragmentListLocationBtnPevious.isEnabled = true
        }

        binding.fragmentListLocationBtnPevious.setOnClickListener{
            viewModel.previousPage(it)
            binding.fragmentListLocationBtnNext.isEnabled = true
        }


        return binding.root

    }

}