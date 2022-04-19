package com.dataart.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dataart.search.model.City
import com.dataart.search.ui.databinding.CityBinding

internal class CityAdapter : ListAdapter<City, CityAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CityBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: CityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) = with(binding) {
            cityNameTextView.text = city.name
            countryTextView.text = city.countryName
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<City>() {

        override fun areItemsTheSame(oldItem: City, newItem: City) =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: City, newItem: City) =
            oldItem == newItem
    }
}