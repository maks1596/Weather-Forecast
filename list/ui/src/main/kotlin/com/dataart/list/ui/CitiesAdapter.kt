package com.dataart.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dataart.list.City
import com.dataart.list.ui.databinding.CityBinding

internal class CitiesAdapter : ListAdapter<City, CitiesAdapter.ViewHolder>(DiffCallback) {

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
            nameTextView.text = city.name

            // TODO Make units ending
            // TODO Round double temperature to pretty form
            dayTemperatureTextView.text = city.temperature.day.toString()
            nightTemperatureTextView.text = city.temperature.night.toString()
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<City>() {

        override fun areItemsTheSame(oldItem: City, newItem: City) =
            oldItem.coordinates == newItem.coordinates
        override fun areContentsTheSame(oldItem: City, newItem: City) = oldItem == newItem
    }
}