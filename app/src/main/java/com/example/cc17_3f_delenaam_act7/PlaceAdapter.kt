package com.example.cc17_3f_delenaam_act7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cc17_3f_delenaam_act7.databinding.ItemPlaceBinding


class PlaceAdapter(
    private val places: List<Place>,
    private val onItemClick: (Place) -> Unit
) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    data class Place(val name: String, val imageResId: Int, val description: String)

    inner class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.placeName.text = place.name
            binding.placeImage.setImageResource(place.imageResId)
            binding.root.setOnClickListener { onItemClick(place) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(places[position])
    }

    override fun getItemCount(): Int = places.size
}
