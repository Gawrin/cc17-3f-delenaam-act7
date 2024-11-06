package com.example.cc17_3f_delenaam_act7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cc17_3f_delenaam_act7.databinding.FragmentPlaceListBinding

class PlaceListFragment : Fragment() {

    private var _binding: FragmentPlaceListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the selected category from arguments
        val selectedCategory = arguments?.getString("category") ?: "Popular"

        // Define place list based on selected category
        val places = when (selectedCategory) {
            getString(R.string.popular) -> listOf(
                PlaceAdapter.Place(getString(R.string.popular_place_1), R.drawable.popular1, getString(R.string.popular_place_1_description)),
                PlaceAdapter.Place(getString(R.string.popular_place_2), R.drawable.popular2, getString(R.string.popular_place_2_description)),
                PlaceAdapter.Place(getString(R.string.popular_place_3), R.drawable.popular3, getString(R.string.popular_place_3_description)),
                PlaceAdapter.Place(getString(R.string.popular_place_4), R.drawable.popular4, getString(R.string.popular_place_4_description)),
                PlaceAdapter.Place(getString(R.string.popular_place_5), R.drawable.popular5, getString(R.string.popular_place_5_description))
            )
            getString(R.string.landmarks) -> listOf(
                PlaceAdapter.Place(getString(R.string.landmark_place_1), R.drawable.landmarks1, getString(R.string.landmark_place_1_description)),
                PlaceAdapter.Place(getString(R.string.landmark_place_2), R.drawable.landmarks2, getString(R.string.landmark_place_2_description)),
                PlaceAdapter.Place(getString(R.string.landmark_place_3), R.drawable.landmarks3, getString(R.string.landmark_place_3_description)),
                PlaceAdapter.Place(getString(R.string.landmark_place_4), R.drawable.landmarks4, getString(R.string.landmark_place_4_description)),
                PlaceAdapter.Place(getString(R.string.landmark_place_5), R.drawable.landmarks5, getString(R.string.landmark_place_5_description))
            )
            getString(R.string.historical) -> listOf(
                PlaceAdapter.Place(getString(R.string.historical_place_1), R.drawable.historical1, getString(R.string.historical_place_1_description)),
                PlaceAdapter.Place(getString(R.string.historical_place_2), R.drawable.historical2, getString(R.string.historical_place_2_description)),
                PlaceAdapter.Place(getString(R.string.historical_place_3), R.drawable.historical3, getString(R.string.historical_place_3_description)),
                PlaceAdapter.Place(getString(R.string.historical_place_4), R.drawable.historical4, getString(R.string.historical_place_4_description)),
                PlaceAdapter.Place(getString(R.string.historical_place_5), R.drawable.historical5, getString(R.string.historical_place_5_description))
            )
            getString(R.string.restaurants) -> listOf(
                PlaceAdapter.Place(getString(R.string.restaurant_place_1), R.drawable.restaurants1, getString(R.string.restaurant_place_1_description)),
                PlaceAdapter.Place(getString(R.string.restaurant_place_2), R.drawable.restaurants2, getString(R.string.restaurant_place_2_description)),
                PlaceAdapter.Place(getString(R.string.restaurant_place_3), R.drawable.restaurants3, getString(R.string.restaurant_place_3_description)),
                PlaceAdapter.Place(getString(R.string.restaurant_place_4), R.drawable.restaurants4, getString(R.string.restaurant_place_4_description)),
                PlaceAdapter.Place(getString(R.string.restaurant_place_5), R.drawable.restaurants5, getString(R.string.restaurant_place_5_description))
            )
            else -> emptyList()
        }

        val adapter = PlaceAdapter(places) { place ->
            navigateToPlaceDetail(place)
        }

        binding.placeRecyclerView.adapter = adapter

        // Set layout based on screen width
        val isTablet = resources.getBoolean(R.bool.is_tablet)
        binding.placeRecyclerView.layoutManager = if (isTablet) {
            GridLayoutManager(requireContext(), 2)
        } else {
            LinearLayoutManager(requireContext())
        }

        // Update the title to reflect the selected category
        (activity as MainActivity).supportActionBar?.title = selectedCategory
    }

    private fun navigateToPlaceDetail(place: PlaceAdapter.Place) {
        val action = PlaceListFragmentDirections.actionPlaceListFragmentToPlaceDetailFragment(
            placeName = place.name,
            imageResId = place.imageResId,
            description = place.description
        )
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
