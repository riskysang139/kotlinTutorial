package com.example.kotlintutorial.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ItemUpcomingBinding


class NowPlayingFilmAdapter(private val film: List<ResultsFilm>) :
    RecyclerView.Adapter<NowPlayingFilmAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_upcoming,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = film[position]

    }

    override fun getItemCount() = film.size

    inner class ViewHolder(val binding: ItemUpcomingBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        film.toMutableList().addAll(film)
        notifyDataSetChanged()
    }
}