package com.example.engway.ui.main.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.engway.R
import com.example.engway.databinding.FragmentHomeBinding
import com.example.engway.model.Category
import com.example.engway.model.recommended


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lista de categorias de exemplo
        val categories = listOf(
            Category("Category 1", R.drawable.travel),
            Category("Category 2", R.drawable.travel),
            Category("Category 3", R.drawable.travel),
            Category("Category 4", R.drawable.travel),
            Category("Category 5", R.drawable.travel),
            Category("Category 6", R.drawable.travel),
            Category("Category 7", R.drawable.travel),
            Category("Category 8", R.drawable.travel),
            Category("Category 9", R.drawable.travel)
        )

        // Configurar o adapter e o RecyclerView
        val categoryAdapter = CategoryAdapter(categories)
        binding.rvCategory.adapter = categoryAdapter
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Lista de recomendações de exemplo
        val recommendations = listOf(
            recommended("Pizza", R.drawable.travel, "Easy", "bgfdqVmVjfk"),
            recommended("Category", R.drawable.travel, "Medium", "dQw4w9WgXcQ"),
            recommended("Pizza", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Category", R.drawable.travel, "Medium", "dQw4w9WgXcQ"),
            recommended("Category", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Pizza", R.drawable.travel, "Easy", "dQw4w9WgXcQ"),
            recommended("Category", R.drawable.travel, "Medium", "dQw4w9WgXcQ"),
            recommended("Category", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Pizza", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Dia a Dia", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Comida", R.drawable.travel, "Hard", "dQw4w9WgXcQ"),
            recommended("Cores", R.drawable.travel, "Hard", "dQw4w9WgXcQ")
        )

        // Configurar o adapter e o RecyclerView
        val recommendedAdapter = RecommendedAdapter(recommendations)
        binding.rvRecommended.adapter = recommendedAdapter
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvRecommended.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

