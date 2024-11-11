package com.example.cc17_3f_delenaam_act7

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cc17_3f_delenaam_act7.databinding.FragmentCategorySelectionBinding

class CategorySelectionFragment : Fragment() {

    private var _binding: FragmentCategorySelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategorySelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = listOf(
            CategoryAdapter.Category("Popular", R.drawable.popular),
            CategoryAdapter.Category("Landmarks", R.drawable.landmarks),
            CategoryAdapter.Category("Historical", R.drawable.historical),
            CategoryAdapter.Category("Restaurants", R.drawable.restaurants)
        )

        val adapter = CategoryAdapter(categories) { category ->
            navigateToPlaceList(category.title)
        }


        val orientation = resources.configuration.orientation
        val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE
        val spanCount = if (isLandscape) 4 else 2

        binding.categoryRecyclerView.layoutManager = GridLayoutManager(requireContext(), spanCount)

        binding.categoryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.categoryRecyclerView.adapter = adapter
    }

    private fun navigateToPlaceList(category: String) {
        val action = CategorySelectionFragmentDirections
            .actionCategorySelectionFragmentToPlaceListFragment(category)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

