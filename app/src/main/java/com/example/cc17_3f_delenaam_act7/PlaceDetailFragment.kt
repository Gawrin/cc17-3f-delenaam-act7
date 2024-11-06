package com.example.cc17_3f_delenaam_act7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cc17_3f_delenaam_act7.databinding.FragmentPlaceDetailBinding

class PlaceDetailFragment : Fragment() {

    private var _binding: FragmentPlaceDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val placeName = arguments?.getString("placeName") ?: getString(R.string.place_detail_name)
        val imageResId = arguments?.getInt("imageResId") ?: R.drawable.popular1
        val description = arguments?.getString("description") ?: getString(R.string.place_description_one)

        binding.placeDetailName.text = placeName
        binding.placeDetailImage.setImageResource(imageResId)
        binding.placeDescriptionOne.text = description

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
