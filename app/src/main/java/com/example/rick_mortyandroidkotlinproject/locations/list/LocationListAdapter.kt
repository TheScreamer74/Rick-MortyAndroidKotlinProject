package com.example.rick_mortyandroidkotlinproject.locations.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rick_mortyandroidkotlinproject.network.properties.Location
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.databinding.LocationItemViewBinding


class LocationListAdapter(private val onClickListener: LocationListAdapter.OnClickListener): ListAdapter<Location, LocationListAdapter.LocationItemViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class LocationItemViewHolder(private var binding: LocationItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(location: Location?) {
            binding.location = location
            binding.executePendingBindings()

        }

    }

    class OnClickListener(val clickListener: (locationId: Int) -> Unit) {
        fun onClick(locationId:Int) = clickListener(locationId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationItemViewHolder {
        return LocationItemViewHolder(LocationItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LocationItemViewHolder, position: Int) {
        val location = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(location.id)
        }
        holder.bind(location)
    }
}