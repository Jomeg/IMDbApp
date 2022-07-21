package com.example.josebootcampandroid.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.databinding.ItemImagelasmejoresBinding
import com.squareup.picasso.Picasso

class ListMovieAdapter(val listMovie: List<MovieTop>) :
    RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolders>() {
    inner class ListMovieViewHolders(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemImagelasmejoresBinding.bind(view)
        fun render(item: MovieTop) {
            binding.tvNameMovie.text = item.title
            binding.tvPointMovie.text = item.voteAverage.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500${item.backdropPath}")
                .into(binding.ivPrincipalImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListMovieViewHolders(
            layoutInflater.inflate(
                R.layout.item_imagelasmejores,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListMovieViewHolders, position: Int) {
        val item = listMovie[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listMovie.size
}