package com.example.engway.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.engway.databinding.ItemHomeRecommendedBinding
import com.example.engway.model.recommended
import com.example.engway.ui.YouTube.YoutubeActivity


class RecommendedAdapter(private val recommendations: List<recommended>) : RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder>() {

    inner class RecommendedViewHolder(private val binding: ItemHomeRecommendedBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var recommended: recommended

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(recommended: recommended) {
            this.recommended = recommended
            binding.tvModelCategory.text = recommended.name
            binding.imageCategory.setImageResource(recommended.imageResId)
            binding.tvLevel.text = recommended.difficulty
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, YoutubeActivity::class.java).apply {
                putExtra("VIDEO_ID", recommended.videoId)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeRecommendedBinding.inflate(inflater, parent, false)
        return RecommendedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size
}
