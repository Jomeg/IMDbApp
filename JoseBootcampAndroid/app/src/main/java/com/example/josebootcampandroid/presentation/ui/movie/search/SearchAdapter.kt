package com.example.josebootcampandroid.presentation.ui.movie.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.databinding.ItemMovieBinding
import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop
import com.squareup.picasso.Picasso

class SearchAdapter(val SearchMovie: List<Movie>) :
    RecyclerView.Adapter<SearchAdapter.SearchMovieViewHolders>() {
    inner class SearchMovieViewHolders(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)
        fun render(item: Movie) {
            binding.tvMovieTitle.text = item.title
            binding.tvYear.text = item.date
            /*binding.tvStar.text = item.nameCastOfSearch*/
            Picasso.get().load("https://image.tmdb.org/t/p/w500${item.backgroundImage}")
                .into(binding.ivMovie)
            view.setOnClickListener { view.findNavController().navigate(R.id.navigation_detail) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchMovieViewHolders(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolders, position: Int) {
        val item = SearchMovie[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = SearchMovie.size
}